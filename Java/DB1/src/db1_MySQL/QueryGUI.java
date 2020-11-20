package db1_MySQL;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

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
		try 
		{
			//Class.forName("com.mysql.cj.");
			
			String url = "jdbc:mysql://localhost:3306/";
			Connection con = DriverManager.getConnection(url, "root", "root"); //connect to the database
			
			Statement stmt = con.createStatement(); //create the statement for the query
			ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY");
			
			table = new JTable();
			table.setModel(dataModel);
			
			
			stmt.close();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 11, 239, 120);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Copy");
		btnNewButton.setBounds(10, 216, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(106, 217, 218, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
