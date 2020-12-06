package disconnected;

import java.util.regex.*; 
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EditForm extends JDialog {

	private final JPanel contentPanel;
	private JTable table;
	
	boolean isUpdate = true; 
	public static EditForm current;
	
	Connection con = QueryGUI.current.con;
	PreparedStatement stmt = QueryGUI.current.stmt;
	ResultSet rs = QueryGUI.current.rs;
	
	class MyEditTableModel extends DefaultTableModel {
		private String columnNames []={"ID", "NAME", "AGE", "ADDRESS",
				"SALARY"}; 
		
		public MyEditTableModel(){
			super();
			this.setColumnCount(columnNames.length);
			this.setColumnIdentifiers(columnNames);
			this.setRowCount(1); 
		}
		
		public void setRow(Object lineMain[]){  
			this.setRowCount(0);  		
			Object line[] = new Object [columnNames.length];
			line[0]=lineMain[0];
			line[1]=lineMain[1];
			line[2]=lineMain[2];
			line[3]=lineMain[3];
			line[4]=lineMain[4];		
			this.addRow(line);			    		 
		}
		
		public Object[] getRow(){  	
			Object line[] = new Object [columnNames.length];
			line[0]=this.getValueAt(0, 0);
			line[1]=this.getValueAt(0, 1);
			line[2]=this.getValueAt(0, 2);
			line[3]=this.getValueAt(0, 3);
			line[4]=this.getValueAt(0, 4) ;
			return line;			  		 
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
		    if (isUpdate && column==0) { return false;} 
			else return true;
		}
	}

	MyEditTableModel editDataModel = new MyEditTableModel(); 
	
	//#### FORM
	public EditForm() {	
		setResizable(false);
		EditForm.current=this; 
		setBounds(100, 100, 730, 141);
		setModal(true);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); 
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);     
		
		table = new JTable(editDataModel);
		table.setRowHeight(30); 
		table.putClientProperty("terminateEditOnFocusLost", true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 717, 53);
		contentPanel.add(scrollPane);
		
		//#### OK BUTTON
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CONNECT TO DATABASE
				QueryGUI.current.connect();
				QueryGUI.current.updateConnStatus(QueryGUI.current.conStatusTxt);
				
				if(isUpdate) {					
					if (myValidate()) {
						try {
							stmt = con.prepareStatement("UPDATE company SET name = ?, age = ?, address = ?, salary = ? WHERE id = ?");							
							stmt.setString(1, (String)table.getValueAt(0, 1));
							stmt.setInt(2, Integer.parseInt(""+table.getValueAt(0, 2)));
							stmt.setString(3, (String)table.getValueAt(0, 3));
							stmt.setDouble(4, Double.parseDouble(""+table.getValueAt(0, 4)));
							stmt.setInt(5, Integer.parseInt(""+table.getValueAt(0, 0)));
							stmt.executeUpdate();
							stmt.close();
							QueryGUI.current.reload();
							JOptionPane.showMessageDialog(null, "DataBase updated");			
						} 
						catch (SQLException e1) {
								JOptionPane.showMessageDialog(null, "DataBase not updated");
								e1.printStackTrace();
						}						
						EditForm.current.dispose();
					}
				}
				else {
					if (myValidate()) {
						try {							 
							stmt = con.prepareStatement("INSERT INTO company (id,name,age,address,salary) VALUES (?, ?, ?, ?, ?)");
							stmt.setInt(1, Integer.parseInt(""+table.getValueAt(0, 0)));
							stmt.setString(2, (String)table.getValueAt(0, 1));
							stmt.setInt(2, Integer.parseInt(""+table.getValueAt(0, 2)));
							stmt.setString(3, (String)table.getValueAt(0, 3));
							stmt.setDouble(4, Double.parseDouble(""+table.getValueAt(0, 4)));
							stmt.executeUpdate();
							stmt.close();
							QueryGUI.current.reload();
							JOptionPane.showMessageDialog(null, "Data added to DataBase");
						} 
						catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Exception: Data not added to DataBase");
							e1.printStackTrace();
						}						
						EditForm.current.dispose();
					}
				}
				
				//DISCONNECT FROM DATABASE
				QueryGUI.current.disconnect();
				QueryGUI.current.updateConnStatus(QueryGUI.current.conStatusTxt);
			}
		});
		okButton.setBounds(475, 64, 89, 23);
		contentPanel.add(okButton);
		
		//#### CANCEL BUTTON
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditForm.current.dispose();
			}
		});
		cancelButton.setBounds(593, 64, 89, 23);
		contentPanel.add(cancelButton);	
	}
	
	//#### CLEAR METHOD TO CLEAR INPUTS
	public void clear(){ 
		editDataModel.setRowCount(0);
		editDataModel.setRowCount(1);
	}
		
	//#### INPUT CHECKER QUERY INFO
	private boolean myValidate() {
		if(!isUpdate) {
			if(!isNonNegInteger(table.getValueAt(0, 0))) {
				JOptionPane.showMessageDialog(null, "Invalid id");
				return false;				
			}
			try {
				stmt = QueryGUI.current.con.prepareStatement("SELECT * FROM company WHERE id = ?");
				stmt.setInt(1,Integer.parseInt(""+table.getValueAt(0, 0)));
				stmt.executeUpdate();
				rs = stmt.getGeneratedKeys();
				stmt.close();

				if (rs.first()) {
					JOptionPane.showMessageDialog(null, "Invalid id: already in Database");
					return false;
				}
				rs.close();

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "DataBase inaccessible");
				return false;
			}		
		}
		if(!isNonNegInteger(table.getValueAt(0, 2))) {
			JOptionPane.showMessageDialog(null, "Invalid age: age must be a greater than 0");
			return false;				
		}
		if(!isValidName(table.getValueAt(0,1))) {
			JOptionPane.showMessageDialog(null, "Invalid name: Letters only and it must start with Uppercase and all other need to be lowercase");
			return false;	
		}
		if(!isNonNegDouble(table.getValueAt(0, 4))) {
			JOptionPane.showMessageDialog(null, "Invalid salary: salary must be a non-negative double");
			return false;				
		}
		
		return true;
	}	
		
	//#### INPUT CHECKER INT
	static boolean isNonNegInteger(Object s) {
		if (s==null){return false;}
		try{
			 int r=Integer.parseInt(""+s);
			 return r>0 ? true: false;
		}
		catch (Exception e){
			return false;
		}
	}
	
	//#### INPUT CHECKER DOUBLE
	static boolean isNonNegDouble(Object s) {
		if (s==null) return false; 
		try{
			 double r=Double.parseDouble(""+s);
			 return r>=0? true : false;
		}
		catch (Exception e){
			return false;
		}
	}
	
	//#### INPUT CHECKER NAME
	static boolean isValidName(Object s) {
		if (s==null) return false;
		try {
			String st = (String)(s);
			return Pattern.matches("[A-Z]{1}[a-z]", st);
		}
		catch (Exception e){
			return false;
		}
	}
	
}
