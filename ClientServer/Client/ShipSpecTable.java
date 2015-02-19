import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShipSpecTable {
	private JTable m_table;
	private DefaultTableModel m_model;
	
	public ShipSpecTable() {
		m_table = new JTable();
	}
	
	public void setModel(Player player) {
		Ship ship = player.getS();
		ShipSpec shipspecs = ship.getSpecs();
		String[][] specs = new String[9][2];
			specs[0][0] = "ID";
				specs[0][1] = shipspecs.getId();
			specs[1][0] = "NAME";
				specs[1][1] = shipspecs.getName();
			specs[2][0] = "CLASS";
				specs[2][1] = shipspecs.getShipClass();
			specs[3][0] = "EMPIRE";
				specs[3][1] = shipspecs.getEmp().getName();
			specs[4][0] = "ENERGY LEVEL";
				specs[4][1] = Integer.toString(ship.getCurrEnergy()) + "/" + Integer.toString(shipspecs.getMaxEnergy());
			specs[5][0] = "SHIELD LEVEL";
				specs[5][1] = Integer.toString(ship.getCurrShields()) + "/" + Integer.toString(shipspecs.getMaxShields());
			specs[6][0] = "MAX SPEED";
				specs[6][1] = Integer.toString(shipspecs.getMaxSpeed());
			specs[7][0] = shipspecs.getEnergyWep().getName();
				specs[7][1] = Integer.toString(shipspecs.getEnergyWep().getYield());
			specs[8][0] = shipspecs.getMissileWep().getName();
				specs[8][1] = Integer.toString(shipspecs.getMissileWep().getYield()) +
						"     (" + Integer.toString(ship.getCurrMissiles()) + " left)";
		m_model = new DefaultTableModel(specs, new String[] {"ATTRIBUTES", "VALUE"}) {
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
