package CLIENT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Cell extends JPanel {

	private Color m_DefaultBackground;
	
	public Cell() {
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				m_DefaultBackground = getBackground();
				setBackground(Color.ORANGE);
			}
			
			public void mouseExited(MouseEvent e) {
				setBackground(m_DefaultBackground);
			}
		});
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(55, 55);
	}
}
