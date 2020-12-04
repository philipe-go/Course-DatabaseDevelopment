package connectedMode;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectedMode.EditForm.MyEditTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EditForm extends JDialog {

	private final JPanel contentPanel;
	private JTable table;
	
	boolean isUpdate = true; 
	
	public static EditForm current;
	
	
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
	
	public void clear(){ 
		//editDataModel.setRow(new Object[] {null, null, null, null , null});
		editDataModel.setRowCount(0);  // Delete the lines (there is only one)
		editDataModel.setRowCount(1);  // Add an empty line
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			EditForm dialog = new EditForm();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public EditForm() {	
		setResizable(false);
		EditForm.current=this; 
		setBounds(100, 100, 730, 183);
		
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
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isUpdate) {					
					if (myValidate()) {
						try {
							QueryGUI.current.stmt.executeUpdate(
									"UPDATE company SET name = '"+ table.getValueAt(0, 1)+"',"+
									" age = "+table.getValueAt(0, 2)+","+
									" address =  '"+ table.getValueAt(0, 3) +"',"+
									" salary = "+ table.getValueAt(0, 4) +
									" WHERE id = "+table.getValueAt(0, 0)
							);
							QueryGUI.current.reload();
							JOptionPane.showMessageDialog(null, "DataBase updated");
						} 
						catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "DataBase not updated");
							e1.printStackTrace();
						}						
						EditForm.current.dispose();
					} //end if validate()
				} //end if isUpdate 
				else { // not isUpdate  -- add
					if (myValidate()) {
						try {
							QueryGUI.current.stmt.executeUpdate(
									"INSERT INTO company (id,name,age,address,salary)" +
									" VALUES (" +
										table.getValueAt(0, 0)+","+
										"'" + table.getValueAt(0, 1)+"',"+
										table.getValueAt(0, 2)+","+
										"'"+ table.getValueAt(0, 3) +"',"+
										table.getValueAt(0, 4) + 
									")"								
							);
							QueryGUI.current.reload();
							JOptionPane.showMessageDialog(null, "Data added to DataBase");
						} 
						catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Exception: Data not added to DataBase");
							e1.printStackTrace();
						}						
						EditForm.current.dispose();
					} //end if validate()
				} //end else isUpdate 
			} //end actionPerformed(ActionEvent e) 
		});
		okButton.setBounds(476, 100, 89, 23);
		contentPanel.add(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditForm.current.dispose();
			}
		});
		cancelButton.setBounds(594, 100, 89, 23);
		contentPanel.add(cancelButton);	
		
	}
	
	private boolean myValidate() {
		if(!isUpdate) {
			if(!isNonNegInteger(table.getValueAt(0, 0))) {
				JOptionPane.showMessageDialog(null, "Invalid id");
				return false;				
			}
			try {
				ResultSet rs = QueryGUI.current.stmt.executeQuery( 
						"SELECT * FROM company WHERE id =  "+ table.getValueAt(0, 0)
						);
				if (rs.first()) {
					JOptionPane.showMessageDialog(null, "Repeated id: id already in Database");
					return false;
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "DataBase inaccessible");
				return false;
			}		
		}
		if(!isNonNegInteger(table.getValueAt(0, 2))) {
			JOptionPane.showMessageDialog(null, "Invalid age: age must be a non-negative integer");
			return false;				
		}
		if(!isNonNegDouble(table.getValueAt(0, 4))) {
			JOptionPane.showMessageDialog(null, "Invalid salary: salary must be a non-negative double");
			return false;				
		}
		return true;
	}	
	
	static boolean isNonNegInteger(Object s) {
		if (s==null){return false; }
		try{
			 int r=Integer.parseInt(""+s);
			 if (r>=0) { return true; }
			 else { return false; }
		}
		catch (Exception e){
			return false;
		}
	}
	
	static boolean isNonNegDouble(Object s) {
		if (s==null){return false; }
		try{
			 double r=Double.parseDouble(""+s);
			 if (r>=0) { return true; }
			 else { return false; }
		}
		catch (Exception e){
			return false;
		}
	}
}
