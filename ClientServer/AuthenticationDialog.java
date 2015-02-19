import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AuthenticationDialog extends JDialog {

	private static final long serialVersionUID = 1738509094567553993L;
	
	private static final String IPADDRESS_PATTERN = 
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	
	public boolean validateIPAddress( String ipAddress ){ 
		Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
		Matcher matcher = pattern.matcher(ipAddress);
		  return matcher.matches();
		
	}
	
	public void login(JDialog owner, String serverip, Integer port, String user, char[] pass) {
		String correctPass = "p";
		char[] correct = correctPass.toCharArray();
		if(serverip != null && validateIPAddress(serverip) && port != null && 0 < port && port < 65536) {
			if(Arrays.equals(pass,correct)) {
				owner.dispose();
				//ADD JOIN GAME HERE
			}
			else {
				JOptionPane.showMessageDialog(this,"USERNAME OR PASSWORD INCORRECT","AUTHENTICATION ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(this,"INVALID IP ADDRESS OR PORT NUMBER","AUTHENTICATION ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public AuthenticationDialog() {
		GridBagConstraints gbc = new GridBagConstraints();
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		setSize(400,300);
		setTitle("Login");
		setLayout(new GridBagLayout());
		setLocationRelativeTo(rootPane);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("SERVER ADDRESS:"), gbc);
		final JTextField serverField = new JTextField(10);
		gbc.gridx = 1;
		add(serverField, gbc);
		gbc.gridx = 2;
		add(new JLabel("PORT:"));
		gbc.gridx = 3;
		final JTextField portField = new JTextField(3);
		add(portField, gbc);
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		add(new JLabel("USERNAME:"), gbc);
		final JTextField usernameField = new JTextField(10);
		gbc.gridx = 1;
		add(usernameField, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel("PASSWORD:"), gbc);
		final JPasswordField passwordField = new JPasswordField(10);
		gbc.gridx = 1;
		add(passwordField, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		final JDialog parent = this;
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] thepassword = passwordField.getPassword();
				if(serverField.getText().equals("") || portField.getText().equals("") || usernameField.getText().equals("")) {
					JOptionPane.showMessageDialog(parent,"ALL FIELDS ARE REQUIRED!","MISSING INFORMATION",JOptionPane.ERROR_MESSAGE);
				}
				else {
					login(parent, serverField.getText(), Integer.parseInt(portField.getText()), usernameField.getText(), thepassword);
				}
			}
		});
		add(loginButton, gbc);
		setVisible(true);
		
	}
	
}

