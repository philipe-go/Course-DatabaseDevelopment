package pack3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StarfleetGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table;
	
	public static StarfleetGUI current;
	
	Connection con;
	PreparedStatement stmt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarfleetGUI.current = new StarfleetGUI();
					StarfleetGUI.current.setVisible(true);
					EditCaptain.current = new EditCaptain();
					EditCaptain.current.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StarfleetGUI() {
		
		try {
			 String url = "jdbc:mysql://localhost:3306/STARFLEET";
			 con = DriverManager.getConnection(url,"root", "root");
			 stmt = con.prepareStatement("SELECT * FROM STARFLEET");		     
			
			 table = new JTable();
			 reload();		     
		}
		catch( Exception e ) {
			 e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Refresh");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Insert");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCaptain.current.clear();
				EditCaptain.current.isAssign = false;
				EditCaptain.current.setTitle("Add Captain");
				EditCaptain.current.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Remove");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount() == 0) { 
					JOptionPane.showMessageDialog(null, "Please select a line");
				}
				else {
					int lines_delete = table.getSelectedRows().length;
					int opt = JOptionPane.showConfirmDialog(null, 
							   "Sure you want to scrap "+ lines_delete+ " master(s)?",
							   "Confirmation:",
							   JOptionPane.YES_NO_OPTION,
							   JOptionPane.QUESTION_MESSAGE,
							   null); 
					if (opt == 0) {
						try {
							for (int i = 0; i < lines_delete; i++) {
								stmt = con.prepareStatement("DELETE  FROM CAPTAINS WHERE captain_name = ?");
								stmt.setString(1, (String)table.getValueAt(table.getSelectedRows()[i], 0));
								stmt.executeUpdate();
							}
							reload();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Assign");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCaptain.current.clear();
				EditCaptain.current.isAssign = true;	
				if (table.getSelectedRowCount() == 0) { 
					JOptionPane.showMessageDialog(null, "Please select a line");
				}
				else if (table.getSelectedRowCount() >1) {  
					JOptionPane.showMessageDialog(null, "Don't be so rushy. One captain per time.");
				}
				else {
					EditCaptain.current.editDataModel.setRow(getRow(table.getSelectedRows()[0]));
					EditCaptain.current.setTitle("Assign a vessel to the Captain");
					EditCaptain.current.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 22, 434, 239);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
	}
	
	void reload() {
		try {
			stmt = con.prepareStatement(
					"SELECT captain_name, assigned_vessel, vessel_type FROM CAPTAINS, SHIPS "+
					"WHERE (SHIPS.vessel_name = CAPTAINS.assigned_vessel) OR CAPTAINS.assigned_vessel IS NULL "+
					"GROUP BY captain_name;");
			ResultSet rs = stmt.executeQuery();

			 table.setModel(buildTableModel(rs));   
			 
		     rs.close();
		}
		catch( Exception e ) {
			 e.printStackTrace();
		}
	}
	
	private  Object[] getRow(int row){  	
		Object line[] = new Object [table.getColumnCount()]; 
		line[0] = table.getValueAt(row, 0);
		line[1] = table.getValueAt(row, 1); 
		line[2] = table.getValueAt(row, 2);
		return line;			  		 
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> row = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				row.add(rs.getObject(columnIndex));
			}
			data.add(row);
		}

		return new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};
	}
}
