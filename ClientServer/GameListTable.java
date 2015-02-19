package CLIENT;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class GameListTable implements MouseListener {

	private JTable m_table;
	private DefaultTableModel m_model;
	private GameScreenDlg m_gameDlg;
	private DataStore m_ds;
	
	
	public GameListTable() {
		m_ds = DataStore.getDataStore();
		m_gameDlg = new GameScreenDlg();
		m_table = new JTable();
	}
	
	public void setModel(ArrayList<Game> gameList) {
		String[][] gameData = new String[gameList.size()][3];
		Game temp;
			for(int i = 0; i < gameList.size(); i++) {
				temp = gameList.get(i);
				gameData[i][0] = temp.getName();
				gameData[i][1] = Integer.toString(temp.getStardate());
			}
		
		m_model = new DefaultTableModel(gameData, new String[] {"UNIVERSE", "STARDATE"}) {
		
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		m_table.setModel(m_model);
		m_table.setRowSelectionAllowed(true);
		m_table.setGridColor(Color.BLACK);
		m_table.setShowGrid(true);
		m_table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if(me.getClickCount() == 2) {
					Game game = m_gameDlg.showGameScreen(m_ds.getGame(m_table.getSelectedRow()), m_ds.getCurrentUser());
					editGame(game);
				}	
			}
		});
	}
	
	public void addGame(Game game) {
		m_model.addRow(new String[] {
				game.getName(),
				Integer.toString(game.getStardate())
		});
	}
	
	public void editGame(Game game) {
		int row = m_table.getSelectedRow();
		if(row < 0)
			return;
		m_model.setValueAt(game.getName(), row, 0);
		m_model.setValueAt(Integer.toString(game.getStardate()), row, 1);
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
