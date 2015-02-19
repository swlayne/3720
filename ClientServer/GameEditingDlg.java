package CLIENT;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameEditingDlg {
	
	public void restoreGame() {
		JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.add(new JLabel("Enter File Name in format: FileName.dat"));
			JTextField fileNameInput = new JTextField();
			panel.add(fileNameInput);
		int result = JOptionPane.showOptionDialog(null,  panel, "Restore Game", 
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, 
								null, new String[] {"Cancel", "Load"}, null);
		if(result == 1) {
			DataStore.getDataStore().restoreGame(fileNameInput.getText());
		}	
	}
	
	public void saveGame() {
		
	}

}
