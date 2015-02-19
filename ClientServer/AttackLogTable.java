package CLIENT;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AttackLogTable {
	private JTable m_table;
	private DefaultTableModel m_model;
	
	public AttackLogTable() {
		m_table = new JTable();
	}
	
	public void setModel(Player player, int stardate) {
		String[][] log = new String[1][2];
			log[0][0] = Integer.toString(stardate);
			log[0][1] = player.getName() + " has joined the game.";
			
		m_model = new DefaultTableModel(log, new String[] {"STARDATE", "MESSAGE"}) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		m_table.setModel(m_model);
		m_table.setRowSelectionAllowed(true);
		m_table.setGridColor(Color.BLACK);
		m_table.setShowGrid(true);
	}
	
	public void addLog(int stardate, String message) {
		m_model.insertRow(0, new String[] {
				Integer.toString(stardate),
				message
		});
	}
	
	public JTable getTable() {
		return m_table;
	}
	
	public DefaultTableModel getModel() {
		return m_model;
	}
}
