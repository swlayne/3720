import javax.swing.JOptionPane;

public class SystemInformationDlg {

	public void about() {
		String message = "The main window displays the current games in the database. Use the bottons on the\n"
				+ "bottom to Save or Restore a Game. Double click on a Game to join.\n\n"
				+ "The Game window will pop up after double clicking a game. Use the action buttons to perform\n"
				+ "actions like fire missiles, navigate, and scan. Actions made by players will appear in the\n"
				+ "action log at the bottom.\n\n";
		
		JOptionPane.showMessageDialog(null,  message, "About Information", JOptionPane.PLAIN_MESSAGE);
	}

	public void shortcuts() {
		String message = "About Info: shift + A\n"
				+ "Shortcuts:   shift + S\n"
				+ "Exit:            shift + Q\n";
		
		JOptionPane.showMessageDialog(null, message, "Shortcuts", JOptionPane.PLAIN_MESSAGE);
	}
}
