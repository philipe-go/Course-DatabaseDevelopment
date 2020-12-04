package sqlParametric;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Form2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private String conUrl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form2 frame = new Form2();
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
	public Form2() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e1) {					
					e1.printStackTrace();
				}
				conUrl = "jdbc:mysql://localhost:3306/exempleinj?allowMultiQueries=true";			
			}
		});
		setTitle("Additionner 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(127, 50, 191, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 104, 188, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Employee ID:");
		lblNewLabel.setBounds(47, 53, 81, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Salary:");
		lblNewLabel_1.setBounds(47, 107, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(47, 206, 338, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				double num = -1;
				boolean numeric;
		        try {
		        	num = Double.parseDouble(textField_1.getText());
		            numeric = true;
		        } catch (NumberFormatException e_n) {
		            numeric = false;
		        }
				if (numeric) {
					try {
						Connection con = DriverManager.getConnection(conUrl, "root", "root");
						String cmd = "INSERT INTO sal (Id_Emp, Salaire) VALUES (? , ?)" ;
						PreparedStatement  pstmt = con.prepareStatement(cmd);
						pstmt.setString(1, textField.getText());
//						pstmt.setString(2, textField_1.getText()); //cela marche, mais pas une bonne pratique
						pstmt.setDouble(2,num);
						textField_2.setText(pstmt.toString());
						pstmt.executeUpdate();
						pstmt.close();
						con.close();
						textField.setText("");
						textField_1.setText("");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else {
					 JOptionPane.showMessageDialog(null, "Invalid Salary");
				}
				
			}
		});
		btnNewButton.setBounds(296, 151, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblProducedSqlCommand = new JLabel("Produced SQL command:");
		lblProducedSqlCommand.setBounds(47, 181, 151, 14);
		contentPane.add(lblProducedSqlCommand);
	}
}
