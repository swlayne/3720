import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

public class IssueTableDlg extends JDialog implements ActionListener {

	private DataStore m_ds = DataStore.getDataStore();
	private DefaultTableModel m_model;
	private JTable m_table;
	private Project m_project;
	private int m_projectNumber;
	private static int m_nextID;
	private JRadioButton NEW = new JRadioButton("NEW");
	private JRadioButton IN_PROGRESS = new JRadioButton("IN PROGRESS");
	private JRadioButton COMPLETED = new JRadioButton("COMPLETED");
	private JRadioButton WONT_FIX = new JRadioButton("WONT FIX");
		
	public IssueTableDlg() {
		NEW.addActionListener(this);
		IN_PROGRESS.addActionListener(this);
		COMPLETED.addActionListener(this);
		WONT_FIX.addActionListener(this);
	}
	
	public Project showIssues(Project project, int projectNumber) {
		String[] temp = new String[4];
		m_nextID = project.getNumberOfIssues();
		m_project = project;
		m_projectNumber = projectNumber;
		String[] header = {"ID", "Name", "status", "Description"};
		String[][] data = new String[m_project.getNumberOfIssues()][4];
			for(int i = 0; i < m_project.getNumberOfIssues(); i++) {
				temp = m_project.getIssue(i);
				data[i][0] = temp[0];
				data[i][1] = temp[1];
				data[i][2] = temp[2];
				data[i][3] = temp[3];
			}
			
		m_model = new DefaultTableModel(data, header) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		m_table = new JTable();
			m_table.setModel(m_model);
			m_table.setRowSelectionAllowed(true);
			m_table.setGridColor(Color.BLACK);
			m_table.setShowGrid(true);
			m_table.setPreferredScrollableViewportSize(new Dimension(600, 400));
			m_table.setMaximumSize(new Dimension(600,400));
			m_table.setMinimumSize(new Dimension(600, 400));
			m_table.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent me) {
					if(me.getClickCount() == 2) {
						showIssueDescription();
					}	
				}
			});
		
		JScrollPane jsp = new JScrollPane(m_table);
			jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			jsp.setColumnHeaderView(m_table.getTableHeader());
			jsp.setPreferredSize(new Dimension(600, 400));
			jsp.setMaximumSize(new Dimension(600,400));
			jsp.setMinimumSize(new Dimension(600, 400));
			
		JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(100, 400));
			panel.setMaximumSize(new Dimension(100, 400));
			panel.setMinimumSize(new Dimension(100, 400));
			JButton button = new JButton("Add");
				button.addActionListener(this);;
			panel.add(button);
			
			button = new JButton("Edit");
				button.addActionListener(this);
			panel.add(button);
			
			button = new JButton("Delete");
				button.addActionListener(this);
			panel.add(button);
				
		JSplitPane mainPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jsp, panel);
			mainPane.setPreferredSize(new Dimension(700, 500));
			mainPane.setMaximumSize(new Dimension(700, 500));
			mainPane.setMinimumSize(new Dimension(700, 500));	
			
		JOptionPane.showMessageDialog(null,  mainPane, m_project.getTitle() + "'s Issues", JOptionPane.PLAIN_MESSAGE);
		return m_project;
	}
	
	public void addIssue() {
		JTextArea name = new JTextArea();
			name.setPreferredSize(new Dimension(300, 20));
			name.setMaximumSize(new Dimension(300, 20));
			name.setMinimumSize(new Dimension(300, 20));
		
		NEW.setSelected(true);
		IN_PROGRESS.setSelected(false);
		COMPLETED.setSelected(false);
		WONT_FIX.setSelected(false);
			
		JTextPane description = new JTextPane();
		JScrollPane jsp = new JScrollPane(description);
			jsp.setPreferredSize(new Dimension(300, 400));
			jsp.setMaximumSize(new Dimension(300, 400));
			jsp.setMinimumSize(new Dimension(300, 400));
			
		JPanel myPanel = new JPanel();
			myPanel.setPreferredSize(new Dimension(350, 450));
			myPanel.setMaximumSize(new Dimension(350, 450));
			myPanel.setMinimumSize(new Dimension(350, 450));
			myPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			myPanel.add(new JLabel("Issue Name"));
			myPanel.add(name);
			myPanel.add(new JLabel("Issue Status"));
			myPanel.add(new JLabel(" 																	"
					+ "																					"
					+ "																		"));
			myPanel.add(NEW);
			myPanel.add(IN_PROGRESS);
			myPanel.add(COMPLETED);
			myPanel.add(WONT_FIX);
			myPanel.add(new JLabel("                												"
					+ "																				"));
			myPanel.add(new JLabel("Issue Description"));
			myPanel.add(jsp);
		
		int result = JOptionPane.showOptionDialog(null, myPanel,
				"Enter Issue Information",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
				new String[] {"Cancel", "Create"}, null);
		
		if(result == 1) {
			String[] issue = new String[4];
			if(NEW.isSelected()) {
				issue[0] = Integer.toString(m_nextID);
				issue[1] = name.getText();
				issue[2] = "NEW";
				issue[3] = description.getText();
			}
			else if(IN_PROGRESS.isSelected()) {
				issue[0] = Integer.toString(m_nextID);
				issue[1] = name.getText();
				issue[2] = "IN PROGRESS";
				issue[3] = description.getText();
			}
			else if(COMPLETED.isSelected()) {
				issue[0] = Integer.toString(m_nextID);
				issue[1] = name.getText();
				issue[2] = "COMPLETED";
				issue[3] = description.getText();
			}
			else if(WONT_FIX.isSelected()) {
				issue[0] = Integer.toString(m_nextID);
				issue[1] = name.getText();
				issue[2] = "WONT FIX";
				issue[3] = description.getText();
			}
			m_ds.serverIssueUpdate(new AddIssueRequest(m_projectNumber, issue));
			m_project.addIssue(m_nextID, issue);
			m_model.addRow(new String[] {issue[0], issue[1], issue[2], issue[3]});
			m_nextID++;
		}
	}
	
	public void editIssue() {
		int row = m_table.getSelectedRow();
		if(0 <= row && row < m_project.getNumberOfIssues()) {
			String[] issue = m_project.getIssue(row);
			JTextArea name = new JTextArea(issue[1]);
				name.setPreferredSize(new Dimension(300, 20));
				name.setMaximumSize(new Dimension(300, 20));
				name.setMinimumSize(new Dimension(300, 20));
			
			if(issue[2].equals("NEW")) {
				NEW.setSelected(true);
					IN_PROGRESS.setSelected(false);
					COMPLETED.setSelected(false);
					WONT_FIX.setSelected(false);
			} else if(issue[2].equals("IN PROGRESS")) {
					NEW.setSelected(false);
				IN_PROGRESS.setSelected(true);
					COMPLETED.setSelected(false);
					WONT_FIX.setSelected(false);
			} else if(issue[2].equals("COMPLETED")) {
					NEW.setSelected(false);
					IN_PROGRESS.setSelected(false);
				COMPLETED.setSelected(true);
					WONT_FIX.setSelected(false);
			} else if(issue[2].equals("WONT FIX")) {
					NEW.setSelected(false);
					IN_PROGRESS.setSelected(false);
					COMPLETED.setSelected(false);
				WONT_FIX.setSelected(true);
			}
				
			JTextPane description = new JTextPane();
				description.setText(issue[3]);
			JScrollPane jsp = new JScrollPane(description);
				jsp.setPreferredSize(new Dimension(300, 400));
				jsp.setMaximumSize(new Dimension(300, 400));
				jsp.setMinimumSize(new Dimension(300, 400));
				
			JPanel myPanel = new JPanel();
				myPanel.setPreferredSize(new Dimension(350, 450));
				myPanel.setMaximumSize(new Dimension(350, 450));
				myPanel.setMinimumSize(new Dimension(350, 450));
				myPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
				myPanel.add(new JLabel("Issue Name"));
				myPanel.add(name);
				myPanel.add(new JLabel("Issue Status"));
				myPanel.add(new JLabel(" 																	"
						+ "																					"
						+ "																		"));
				myPanel.add(NEW);
				myPanel.add(IN_PROGRESS);
				myPanel.add(COMPLETED);
				myPanel.add(WONT_FIX);
				myPanel.add(new JLabel("                												"
						+ "																				"));
				myPanel.add(new JLabel("Issue Description"));
				myPanel.add(jsp);
			
			int result = JOptionPane.showOptionDialog(null, myPanel,
					"Enter Issue Information",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
					new String[] {"Cancel", "Create"}, null);
			
			if(result == 1) {
				String[] newIssue = new String[4];
				if(NEW.isSelected()) {
					newIssue[0] = issue[0];
					newIssue[1] = name.getText();
					newIssue[2] = "NEW";
					newIssue[3] = description.getText();
				} else if(IN_PROGRESS.isSelected()) {
					newIssue[0] = issue[0];
					newIssue[1] = name.getText();
					newIssue[2] = "IN PROGRESS";
					newIssue[3] = description.getText();
				} else if(COMPLETED.isSelected()) {
					newIssue[0] = issue[0];
					newIssue[1] = name.getText();
					newIssue[2] = "COMPLETED";
					newIssue[3] = description.getText();
				} else if(WONT_FIX.isSelected()) {
					newIssue[0] = issue[0];
					newIssue[1] = name.getText();
					newIssue[2] = "WONT FIX";
					newIssue[3] = description.getText();
				}
				
				m_project.removeIssue(row);
					m_project.addIssue(row, newIssue);
				m_model.setValueAt(newIssue[0], row, 0);
					m_model.setValueAt(newIssue[1], row, 1);
					m_model.setValueAt(newIssue[2], row, 2);
					m_model.setValueAt(newIssue[3], row, 3);
				m_ds.serverIssueUpdate(new EditIssueRequest(m_projectNumber, newIssue));
			}
		}
	}
	
	public void deleteIssue() {
		int row = m_table.getSelectedRow();
		if(0 <= row && row < m_project.getNumberOfIssues()) {
			int result = JOptionPane.showOptionDialog(null,
					"Are you sure you want to delete " + m_project.getIssue(row)[1] + "?",
					"Delete Issue", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE, null,
					new String[] {"No", "Yes" }, null);
			if(result == 1) {
				m_ds.serverIssueUpdate(new DeleteIssueRequest(m_projectNumber, m_project.getIssue(row)));
				m_model.removeRow(row);
				m_project.removeIssue(row);
				m_nextID--;
				for(int i = row; i < m_nextID; i++) {
					m_model.setValueAt(Integer.toString(i), i, 0);
					m_project.getIssue(i)[0] = Integer.toString(i);
				}
			}
		}
	}
	
	public void showIssueDescription() {
		String description = m_project.getIssue(m_table.getSelectedRow())[3];
		JOptionPane.showMessageDialog(null,  description, "Issue Description", JOptionPane.PLAIN_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("Add"))
			addIssue();
		else if(event.getActionCommand().equals("Edit"))
			editIssue();
		else if(event.getActionCommand().equals("Delete"))
			deleteIssue();
		else if(event.getActionCommand() == "NEW") {
			NEW.setSelected(true);
				IN_PROGRESS.setSelected(false);
				COMPLETED.setSelected(false);
				WONT_FIX.setSelected(false);
		} else if(event.getActionCommand() == "IN PROGRESS") {
				NEW.setSelected(false);
			IN_PROGRESS.setSelected(true);
				COMPLETED.setSelected(false);
				WONT_FIX.setSelected(false);
		} else if(event.getActionCommand() == "COMPLETED") {
				NEW.setSelected(false);
				IN_PROGRESS.setSelected(false);
			COMPLETED.setSelected(true);
				WONT_FIX.setSelected(false);
		} else if(event.getActionCommand() == "WONT FIX") {
				NEW.setSelected(false);
				IN_PROGRESS.setSelected(false);
				COMPLETED.setSelected(false);
			WONT_FIX.setSelected(true);
		}
	}
}