import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PlayerListTable {

	private JTable m_table;
	private DefaultTableModel m_model;
	private static DataStore m_ds;
	
	
	public PlayerListTable() {
		m_table = new JTable();
		m_ds = DataStore.getDataStore();
	}
	
	public void setModel(Game game) {
		ArrayList<Player> temp = game.getPlayers();
		String[][] players = new String[temp.size()][1];
		for(int i = 0; i < temp.size(); i++) {
			players[i][0] = temp.get(i).getName();
		}
		m_model = new DefaultTableModel(players, new String[] {"PLAYERS"}) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		m_table.setModel(m_model);
		m_table.setRowSelectionAllowed(true);
		m_table.setGridColor(Color.BLACK);
		m_table.setShowGrid(true);
	}
	
	public JTable getTable() {
		return m_table;
	}
	
	public DefaultTableModel getModel() {
		return m_model;
	}
}
