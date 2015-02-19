import java.util.ArrayList;

public class Project {

	private String m_title;
	private ArrayList<String[]> m_issues;
	
	public Project(String title) {
		m_title = title;
		m_issues = new ArrayList<String[]> ();
	}
	
	public void setTitle(String title) {
		m_title = title;
	}
	
	public String getTitle() {
		return m_title;
	}

	public String[] getIssue(int pos) {
		return m_issues.get(pos);
	}
	
	public int getNumberOfIssues() {
		return m_issues.size();
	}
	
	public void addIssue(int pos, String[] issue) {
		m_issues.add(pos, issue);
	}
	
	public void removeIssue(int pos) {
		m_issues.remove(pos);
	}
	
	public String toString(){
		String issues = "";
		String tmp;
		
		for(int i = 0; i < m_issues.size() ; i++){
			tmp = m_issues.get(i)[0] + " " + m_issues.get(i)[1] + " " + m_issues.get(i)[2] + " " + m_issues.get(i)[3] + "; ";
			issues = issues.concat(tmp);
		}
	
		return("{ " + m_title + ", " + issues + " }");
	}
}
