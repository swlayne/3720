import com.google.gson.Gson;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataStore {

	private ArrayList<Project> m_projects;
	private static JTable m_table;
	private static DefaultTableModel m_model;
	private static DataStore m_dataStore = new DataStore();
	private static final String[] m_header = {"Project Name", "Number of Issues"};
	private static final String m_IPAddress = "http://localhost:8080/";
	private static int m_port;
	
	public static DataStore getDataStore() {
		return m_dataStore;
	}
	
	public void setPort(int port) {
		m_port = port;
	}
	
	public void setTable(JTable table) {
		m_table = table;
	}
	
	public void setModel(DefaultTableModel model) {
		m_model = model;
	}
	
	public JTable getTable() {
		return m_table;
	}
	
	public DefaultTableModel getModel() {
		return m_model;
	}
	
	public Project getProject(int pos) {
		return m_projects.get(pos);
	}
	
	public int getProjectListLength() {
		return m_projects.size();
	}
	
	public String[] getProjectTableHeader() {
		return m_header;
	}
	
	public String[][] getProjectTableData() {
		String[][] data = new String[m_projects.size()][3];
		Project temp;
			for(int i = 0; i < m_projects.size(); i++) {
				temp = m_projects.get(i);
				data[i][0] = temp.getTitle();
				data[i][1] = Integer.toString(temp.getNumberOfIssues());
			}
		return data;
	}
	
	public void addProject(Project project) {
		m_projects.add(project);
		m_model.addRow(new String[] {
				project.getTitle(),
				Integer.toString(project.getNumberOfIssues()),
		});
	}
	
	public void editProject(Project project, int pos) {
		m_projects.remove(pos);
		m_projects.add(pos, project);
		m_model.setValueAt(project.getTitle(), pos, 0);
		m_model.setValueAt(Integer.toString(project.getNumberOfIssues()), pos, 1);
	}
	
	public void removeProject() {
		int row = m_table.getSelectedRow();
		if(0 <= row && row < m_projects.size()) {
			int result = JOptionPane.showOptionDialog(null,
					"Are you sure you want to delete " + m_projects.get(row).getTitle() + "?",
					"Delete Project", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE, null,
					new String[] {"No", "Yes" }, null);
			if(result == 1) {
				m_model.removeRow(row);
				m_projects.remove(row);
			}
		}
	}
	
	public void serverProjectListRequest() {
		System.out.println("********** PROJECT LIST REQUEST **********");
		m_projects = new ArrayList<Project> ();
		ListProjectRequest LPRequest = new ListProjectRequest();
		String jsonRequest = new Gson().toJson(LPRequest);
		String url = m_IPAddress + LPRequest.getClass().getSimpleName();
		System.out.println("Sending Project List Request: " + LPRequest.getClass().getSimpleName());
		HttpRequest httpReq = HttpRequest.post(url).send(jsonRequest);
		
		int status = httpReq.code();
		String jsonResponse = httpReq.body();
		ListProjectResponse LPResponse = new Gson().fromJson(jsonResponse, ListProjectResponse.class);
			for(int i = 0; i < LPResponse.projects.size(); i++) {
				m_projects.add(LPResponse.projects.get(i));
			}	
		System.out.println("Recieved Project List: " + status);
		System.out.println("********** PROJECT LIST REQUEST **********");
	}
	
	public void serverIssueUpdate(ProjectRequest issue) {
		System.out.println();
		System.out.println("********* ISSUE REQUEST **********");
		String jsonRequest = new Gson().toJson(issue);
		String url = m_IPAddress + issue.getClass().getSimpleName();
		System.out.println("Sending Issue Request: " + issue.getClass().getSimpleName());
		HttpRequest httpReq = HttpRequest.post(url).send(jsonRequest);
		int status = httpReq.code();
		System.out.println("********** ISSUE REQUEST **********");
	}
}