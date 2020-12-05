package db1_MySQL;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
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

public class QueryGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryGUI frame = new QueryGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QueryGUI() {
		try {
			 String url = "jdbc:mysql://localhost:3306/EMP";
			 Connection con = DriverManager.getConnection(url,"root", "root");
			 //
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY" );
		     
			 // table = new JTable(buildTableModel(rs));
			 table = new JTable();
			 table.setModel(buildTableModel(rs));
			 
		     rs.close();
		     stmt.close();
		     con.close();
		}
		catch( Exception e ) {
			 e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// JScrollPane scrollPane = new JScrollPane(table);
		JScrollPane scrollPane = new JScrollPane();  // put table in the constructor or use setViewportView
		scrollPane.setViewportView(table);
		scrollPane.setBounds(0, 0, 428, 183);
		contentPane.add(scrollPane);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnNewButton = new JButton("Copy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRows().length==1) { 
					textField.setText(table.getValueAt(table.getSelectedRows()[0], 0)+ 
							" " +table.getValueAt(table.getSelectedRows()[0], 1));
				}
			}
		});
		btnNewButton.setBounds(25, 200, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(159, 201, 220, 22);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
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
