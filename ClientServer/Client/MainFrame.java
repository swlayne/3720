import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class MainFrame extends JFrame implements ActionListener {

	private SystemInformationDlg m_AboutDlg = new SystemInformationDlg();
	private GameEditingDlg m_GameDlg = new GameEditingDlg();
	private static DataStore m_ds = DataStore.getDataStore();
	
	public MainFrame(String caption) {
		super(caption);
	}
	
	public void initFrame() {	
		GameListTable gameTable = new GameListTable();
			gameTable.setModel(m_ds.getGameList());
			m_ds.setGameListTable(gameTable);
		
		this.setSize(800, 300);
		ImageIcon img = new ImageIcon("tiger.jpg");
		this.setIconImage(img.getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		JScrollPane jsp = new JScrollPane(gameTable.getTable());
			jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			jsp.setColumnHeaderView(gameTable.getTable().getTableHeader());
			jsp.setSize(new Dimension(790, 280));
		this.getContentPane().add(jsp);
			
		JMenuBar menuBar = new JMenuBar();
			menuBar.setBorderPainted(true);
			menuBar.setBackground(Color.ORANGE);
			menuBar.setForeground(Color.ORANGE);
		
			JMenu menu = new JMenu("File");
				menu.setMnemonic(KeyEvent.VK_F);
				menu.getAccessibleContext().setAccessibleDescription("The File Menu");
				menu.setLayout(new BorderLayout());
			menuBar.add(menu);
				
				JMenuItem menuItem = new JMenuItem("Exit", KeyEvent.VK_1);
					menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.SHIFT_MASK));
					menuItem.getAccessibleContext().setAccessibleDescription("Exit Button");
					menuItem.addActionListener(this);
				menu.add(menuItem);
				
			menu = new JMenu("Help");
				menu.setMnemonic(KeyEvent.VK_H);
				menu.getAccessibleContext().setAccessibleDescription("The Help Menu");
				menu.setLayout(new BorderLayout());
			menuBar.add(menu);
			
				menuItem = new JMenuItem("About", KeyEvent.VK_2);
					menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.SHIFT_MASK));
					menuItem.getAccessibleContext().setAccessibleDescription("About Button");
					menuItem.addActionListener(this);
				menu.add(menuItem);
				
				menuItem = new JMenuItem("Shortcuts", KeyEvent.VK_3);
					menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
					menuItem.getAccessibleContext().setAccessibleDescription("Shortcuts Button");
					menuItem.addActionListener(this);
				menu.add(menuItem);
		this.setJMenuBar(menuBar);
		
		JPanel panel = new JPanel();
			JButton button = new JButton("Restore");
				button.addActionListener(this);
			panel.add(button);
				button = new JButton("Save");
				button.addActionListener(this);
			panel.add(button);
		this.add(panel, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand() == "About")
			m_AboutDlg.about();
		else if (event.getActionCommand() == "Shortcuts")
			m_AboutDlg.shortcuts();
		else if(event.getActionCommand() == "Restore")
			m_GameDlg.restoreGame();
/*		else if(event.getActionCommand() == "Save")
			m_GameDlg.saveGame();
*/		else if(event.getActionCommand() == "Exit")
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}

