import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class SystemInformationDlg extends JDialog {

	public void about() {
		String message = "The main window displays the current projects in the database. Use the bottons on the\n"
				+ "bottom to Create/Edit/Delete Projects. Double click on a project to view/edit it's issue list.\n\n"
				+ "The issue window displays the current issues for the project selected in the main window. Use the\n"
				+ "buttons on the bottom to Create/Edit/Delete Issues for the current Project. Double click on an\n"
				+ "Issue to view its full description.\n\n";
		
		JOptionPane.showMessageDialog(null,  message, "About Information", JOptionPane.PLAIN_MESSAGE);
	}

	public void shortcuts() {
		String message = "About Info: shift + A\n"
				+ "Shortcuts:   shift + S\n"
				+ "Exit:            shift + Q\n";
		
		JOptionPane.showMessageDialog(null, message, "Shortcuts", JOptionPane.PLAIN_MESSAGE);
	}
}
