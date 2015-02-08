import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ProjectTable implements MouseListener {

	private JTable m_table;
	private DefaultTableModel m_model;
	private IssueTableDlg m_issueDlg;
	private Project m_project;
	private static DataStore m_ds;
	
	
	public ProjectTable() {
		m_issueDlg = new IssueTableDlg();
		m_ds = DataStore.getDataStore();
		m_model = new DefaultTableModel(m_ds.getProjectTableData(), m_ds.getProjectTableHeader()) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		m_ds.setModel(m_model);
		
		m_table = new JTable();
			m_table.setModel(m_model);
			m_table.setRowSelectionAllowed(true);
			m_table.setGridColor(Color.BLACK);
			m_table.setShowGrid(true);
			m_table.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent me) {
					if(me.getClickCount() == 2) {
						m_project = m_issueDlg.showIssues(m_ds.getProject(m_table.getSelectedRow()), m_table.getSelectedRow());
						m_ds.editProject(m_project, m_table.getSelectedRow());
					}
					
				}
			});
		m_ds.setTable(m_table);
	}
	
	public JTable getTable() {
		return m_table;
	}
	
	public DefaultTableModel getModel() {
		return m_model;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
