import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class GameScreenDlg implements ActionListener {

	private static ArrayList<Game> m_CurrentGames = new ArrayList<Game> ();
	private DataStore m_ds = DataStore.getDataStore();
	private Game m_game;
	private Player m_user;
	private JLabel m_date;
	private AttackLogTable m_AttackLogTable;
	private PlayerListTable m_PlayerTable;
	private ShipSpecTable m_SpecsTable;
	
	public Game showGameScreen(Game game, Player user) {
		if(!m_CurrentGames.contains(game)) {
			m_CurrentGames.add(game);
			m_game = game;
			m_user = user;
			
			JPanel left = new JPanel();
				left.setPreferredSize(new Dimension(300, 520));
				left.setMinimumSize(new Dimension(300, 520));
				left.setMaximumSize(new Dimension(300, 520));
				left.setLayout(new FlowLayout(FlowLayout.LEFT));
				
				JPanel stardate = new JPanel();
					stardate.setLayout(new FlowLayout(FlowLayout.LEFT));
					stardate.setPreferredSize(new Dimension(200, 20));
					stardate.setMinimumSize(new Dimension(200, 20));
					stardate.setMaximumSize(new Dimension(200, 20));
					m_date = new JLabel("STARDATE: " + Integer.toString(m_game.getStardate()));
					stardate.add(m_date);
				left.add(stardate);
				
				JPanel players = new JPanel();
					players.setLayout(new FlowLayout(FlowLayout.LEFT));
					players.setPreferredSize(new Dimension(250, 168));
					players.setMinimumSize(new Dimension(250, 168));
					players.setMaximumSize(new Dimension(250, 168));
					m_PlayerTable = new PlayerListTable();
						m_PlayerTable.setModel(m_game);
					JScrollPane playerJSP = new JScrollPane(m_PlayerTable.getTable());
						playerJSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
						playerJSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
						playerJSP.setColumnHeaderView(m_PlayerTable.getTable().getTableHeader());
						playerJSP.setPreferredSize(new Dimension(250, 168));
						playerJSP.setMinimumSize(new Dimension(250, 168));
						playerJSP.setMaximumSize(new Dimension(250, 168));
					players.add(playerJSP);
				left.add(players);
				
				JPanel shipSpecs = new JPanel();
					shipSpecs.setLayout(new FlowLayout(FlowLayout.LEFT));
					shipSpecs.setPreferredSize(new Dimension(250, 168));
					shipSpecs.setMinimumSize(new Dimension(250, 168));
					shipSpecs.setMaximumSize(new Dimension(250, 168));
					m_SpecsTable = new ShipSpecTable();
						m_SpecsTable.setModel(m_user);
					JScrollPane specJSP = new JScrollPane(m_SpecsTable.getTable());
						specJSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
						specJSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
						specJSP.setColumnHeaderView(m_SpecsTable.getTable().getTableHeader());
						specJSP.setPreferredSize(new Dimension(250, 168));
						specJSP.setMinimumSize(new Dimension(250, 168));
						specJSP.setMaximumSize(new Dimension(250, 168));
					shipSpecs.add(specJSP);
				left.add(shipSpecs);
				
				JPanel actionButtons = new JPanel();
					actionButtons.setLayout(new FlowLayout(FlowLayout.LEFT));
					actionButtons.setPreferredSize(new Dimension(280, 200));
					actionButtons.setMinimumSize(new Dimension(280, 200));
					actionButtons.setMaximumSize(new Dimension(280, 200));
					JButton button = new JButton("SECTOR SCAN");
						button.addActionListener(this);
					actionButtons.add(button);
						button = new JButton("SHIP SCAN");
						button.addActionListener(this);
					actionButtons.add(button);
						button = new JButton("NAVIGATE");
						button.addActionListener(this);
					actionButtons.add(button);
					actionButtons.add(new JLabel("     "));
						button = new JButton("SET ALERT");
						button.addActionListener(this);
					actionButtons.add(button);
						button = new JButton("FIRE LASER");
						button.addActionListener(this);
					actionButtons.add(button);
					actionButtons.add(new JLabel("    "));
						button = new JButton("FIRE MISSILE");
						button.addActionListener(this);
					actionButtons.add(button);
						button = new JButton("REFRESH");
						button.addActionListener(this);
					actionButtons.add(button);
				left.add(actionButtons);
					
			JPanel right = new JPanel();
				right.setPreferredSize(new Dimension(500, 520));
				right.setMinimumSize(new Dimension(500, 520));
				right.setMaximumSize(new Dimension(500, 520));
				right.setLayout(new FlowLayout(FlowLayout.LEFT));
				GameGrid gamegrid = new GameGrid();
				right.add(gamegrid);
					button = new JButton("SECTOR VIEW");
					button.addActionListener(this);
				right.add(button);
					button = new JButton("UNIVERSE VIEW");
					button.addActionListener(this);
				right.add(button);

			JPanel bottomPane = new JPanel();
				bottomPane.setPreferredSize(new Dimension(800, 200));
				bottomPane.setMinimumSize(new Dimension(800, 200));
				bottomPane.setMaximumSize(new Dimension(800, 200));
				m_AttackLogTable = new AttackLogTable();
					m_AttackLogTable.setModel(m_user, m_game.getStardate());
				JScrollPane logJSP = new JScrollPane(m_AttackLogTable.getTable());
					logJSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					logJSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					logJSP.setColumnHeaderView(m_AttackLogTable.getTable().getTableHeader());
					logJSP.setPreferredSize(new Dimension(700, 200));
					logJSP.setMinimumSize(new Dimension(700, 200));
					logJSP.setMaximumSize(new Dimension(700, 200));
				bottomPane.add(logJSP);	
				
			JSplitPane topPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
			JSplitPane mainPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPane, bottomPane);
			
			int result = JOptionPane.showOptionDialog(null, mainPane, m_game.getName(), 
									JOptionPane.CLOSED_OPTION, JOptionPane.PLAIN_MESSAGE, 
									null, new String[] {"Leave Game", "Save Game"}, null);
			if(result == 1) {
				System.out.println("Game Saved");
			} else if(result == 0) {
				System.out.println("Game Left");
			}
			
			m_CurrentGames.remove(m_CurrentGames.indexOf(game));
		} else {
			JOptionPane.showMessageDialog(null, "You are already playing this game in another window.");
		}
		return m_game;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand() == "SECTOR SCAN") {
			m_AttackLogTable.addLog(m_game.getStardate(), m_user.getName() + " scanned the Sector.");
			m_game.incrementStarDate();
			m_date.setText("STARDATE: " + Integer.toString(m_game.getStardate()));
		} else if(event.getActionCommand() == "SHIP SCAN") {
			m_AttackLogTable.addLog(m_game.getStardate(), m_user.getName() + " scanned a Ship.");
			m_game.incrementStarDate();
			m_date.setText("STARDATE: " + Integer.toString(m_game.getStardate()));
		} else if(event.getActionCommand() == "NAVIGATE") {
			m_AttackLogTable.addLog(m_game.getStardate(), m_user.getName() + " navigated around the Sector.");
			m_game.incrementStarDate();
			m_date.setText("STARDATE: " + Integer.toString(m_game.getStardate()));
		} else if(event.getActionCommand() == "SET ALERT") {
			m_AttackLogTable.addLog(m_game.getStardate(), m_user.getName() + " set his Alert Status.");
			m_game.incrementStarDate();
			m_date.setText("STARDATE: " + Integer.toString(m_game.getStardate()));
		} else if(event.getActionCommand() == "FIRE LASER") {
			m_AttackLogTable.addLog(m_game.getStardate(), m_user.getName() + " fired his lasers!");
			m_game.incrementStarDate();
			m_date.setText("STARDATE: " + Integer.toString(m_game.getStardate()));
		} else if(event.getActionCommand() == "FIRE MISSILE") {
			if(m_user.getS().getCurrMissiles() > 0) {
				m_AttackLogTable.addLog(m_game.getStardate(), m_user.getName() + " fired a missile!!!");
				m_game.incrementStarDate();
				m_user.getS().decrementMissileLevel();
				m_SpecsTable.setModel(m_user);
				m_date.setText("STARDATE: " + Integer.toString(m_game.getStardate()));
			} else
				JOptionPane.showMessageDialog(null, "You don't appear to have any Missiles left!");
		} else if(event.getActionCommand() == "REFRESH") {
			m_AttackLogTable.addLog(m_game.getStardate(), m_user.getName() + " passed.");
			m_game.incrementStarDate();
			m_date.setText("STARDATE: " + Integer.toString(m_game.getStardate()));
		}	
	}
}
