package disconnected;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class QueryGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	protected JLabel conStatusTxt;
	
	public static QueryGUI current;
	
	boolean isConnected = false;
	
	Connection con;
	Statement stm;
	PreparedStatement stmt;
	ResultSet rs;

	//#### MAIN
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryGUI.current = new QueryGUI();
					QueryGUI.current.setVisible(true);
					EditForm.current = new EditForm();
					EditForm.current.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//#### FORM
	public QueryGUI() {
		table = new JTable();
		connect(); //CONNECT TO DATABASE
		reload();
//		disconnect(); //DISCONNECT FROM DATABASE
				
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				disconnect();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 240);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnNewMenu_2 = new JMenu("Database");
		menuBar.add(mnNewMenu_2);
		
		
		//#### CONNECT BUTTON
		JMenuItem connectBtn = new JMenuItem("Connect");
		connectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
				updateConnStatus(conStatusTxt);
			}
		});
		mnNewMenu_2.add(connectBtn);
		
		//#### DISCONNECT BUTTON
		JMenuItem disconnectBtn = new JMenuItem("Disconnect");
		disconnectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disconnect();
				updateConnStatus(conStatusTxt);
			}
		});
		mnNewMenu_2.add(disconnectBtn);
		
		//#### EDIT BUTTON
		JMenu mnNewMenu = new JMenu("Edit");
		menuBar.add(mnNewMenu);
		
		//#### INSERT BUTTON
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Insert");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				connect();
				updateConnStatus(conStatusTxt);
				
				EditForm.current.clear();
				EditForm.current.isUpdate = false;
				EditForm.current.setTitle("Add employee");
				EditForm.current.setVisible(true);

			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		//#### UPDATE BUTTON
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Update");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
connect();
updateConnStatus(conStatusTxt);
				EditForm.current.clear();
				EditForm.current.isUpdate = true;	
				if (table.getSelectedRowCount() == 0) { 
					JOptionPane.showMessageDialog(null, "No line is selected");
				}
				else if (table.getSelectedRowCount() >1) {  
					JOptionPane.showMessageDialog(null, "Multiple lines are selected");
				}
				else {
					EditForm.current.editDataModel.setRow(getRow(table.getSelectedRows()[0]));
					EditForm.current.setTitle("Update employee");
					EditForm.current.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		//#### DELETE BUTTON
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Delete");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount() == 0) { 
					JOptionPane.showMessageDialog(null, "No line is selected");
				}
				else {
					int n_lines_to_delete = table.getSelectedRows().length;
					int opt = JOptionPane.showConfirmDialog(null, 
							   "Are you sure you want to delete "+ n_lines_to_delete+ " line(s)?",
							   "Confirmation",
							   JOptionPane.YES_NO_OPTION,
							   JOptionPane.QUESTION_MESSAGE,
							   null); 
					if (opt == 0) {
						connect();
						try {
							for (int i = 0; i < n_lines_to_delete; i++) {
																		
								stmt = con.prepareStatement("DELETE FROM company WHERE id = ?");
								stmt.setInt(1,Integer.parseInt(""+table.getValueAt(table.getSelectedRows()[i], 0)));
								stmt.executeUpdate();
							}
							reload();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						disconnect();
					}
				}
				updateConnStatus(conStatusTxt);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		//#### HELP BUTTON
		JMenu mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);
		
		//#### ABOUT BUTTON
		JMenuItem mntmNewMenuItem = new JMenuItem("About");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Database Project - Fall 2020 - Philipe Gouveia");
			}
		});
		
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setBounds(0, 27, 434, 156);
		contentPane.add(scrollPane);
		
		
		JLabel lblNewLabel = new JLabel("Database connection status:");
		lblNewLabel.setBounds(68, 0, 162, 16);
		contentPane.add(lblNewLabel);
		
		conStatusTxt = new JLabel("Lulu");
		conStatusTxt.setBackground(Color.GRAY);
		conStatusTxt.setBounds(240, 1, 113, 14);
		contentPane.add(conStatusTxt);	
		
		updateConnStatus(conStatusTxt);
	}
	
	//#### DATABASE CONNECTION
	void connect() {
		try {
			 String url = "jdbc:mysql://localhost:3306/EMP";
			 con = DriverManager.getConnection(url,"root", "root");
		 
			 isConnected = true;
		}
		catch(Exception ex) {
			 ex.printStackTrace();
		}
	}
	
	//#### DATABASE DISCONNECTION
	void disconnect() {
		try {
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
			con.close();
			isConnected = false;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	//#### UPDATE VISUAL INFORMATION ABOUT CONNECTION STATUS
	void updateConnStatus(JLabel textField)
	{
		if (isConnected) textField.setText("CONNECTED");
		else if (!isConnected) textField.setText("DISCONNECTED");
	}
	
	
	//#### REFRESH TABLE WITH DATABASE DATA
	void reload() {
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM COMPANY"); 
			ResultSet rs = stmt.executeQuery();
			table.setModel(buildTableModel(rs));
			
			rs.close();
			stmt.close();
		}
		catch( Exception e ) {
			 e.printStackTrace();
		}
	}

	
	private  Object[] getRow(int row){  	
		Object lign[] = new Object [table.getColumnCount()]; 
		lign[0] = table.getValueAt(row, 0);
		lign[1] = table.getValueAt(row, 1); 
		lign[2] = table.getValueAt(row, 2);
		lign[3] = table.getValueAt(row, 3);
		lign[4] = table.getValueAt(row, 4) ;
		return lign;			  		 
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
				return false;
			}
		};
	}
}
