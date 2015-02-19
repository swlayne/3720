package CLIENT;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class GameGrid  extends JPanel {

	private ArrayList<Cell> m_Cells;
	
	public GameGrid() {
		setLayout(new GridBagLayout());
		m_Cells = new ArrayList<Cell> ();
		
		GridBagConstraints gbc = new GridBagConstraints();
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				gbc.gridx = col;
				gbc.gridy = row;
				
				Cell cell = new Cell();
				Border border = null;
				if(row < 7) {
					if(col < 7)
						border = new MatteBorder(1, 1, 0 ,0, Color.GRAY);
					else
						border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
				} else {
					if(col < 7)
						border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
					else
						border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
				}
				cell.setBorder(border);
				m_Cells.add(cell);
				add(cell, gbc);
			}
		}
	}
	
	public void fillGameGrid(Game game) {
		
	}
}
