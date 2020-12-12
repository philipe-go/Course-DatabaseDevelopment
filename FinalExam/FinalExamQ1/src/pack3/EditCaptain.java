package pack3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EditCaptain extends JDialog {
	
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel;
	private JTable table;
	
	boolean isAssign = true; 
	
	public static EditCaptain current;

	class MyEditTableModel extends DefaultTableModel {
		private static final long serialVersionUID = 1L;
		private String columnNames []={"CAPTAIN", "ASSIGNED VESSEL"}; 
		
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
		this.addRow(line);	
		}
		
		public Object[] getRow(){  	
			Object line[] = new Object [columnNames.length];
			line[0]=this.getValueAt(0, 0);
			line[1]=this.getValueAt(0, 1);
			return line;			  		 
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
		    if (isAssign && column==0) { return false;} 
			else return true;
		}
	}
	
	MyEditTableModel editDataModel = new MyEditTableModel(); 
	public void clear(){ 
		editDataModel.setRowCount(0);
		editDataModel.setRowCount(1);
	}

	public EditCaptain() {
		setResizable(false);
		EditCaptain.current=this; 
		setBounds(100, 100, 683, 153);
		
		setModal(true);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        
		getContentPane().setLayout(new BorderLayout());
        contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 647, 64);
			contentPanel.add(scrollPane);
			{
				table = new JTable(editDataModel);
				table.setRowHeight(30); 
				table.putClientProperty("terminateEditOnFocusLost", true);
				scrollPane.setColumnHeaderView(table);
			}
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(isAssign) {					
							if (myValidate()) {
								try {
									StarfleetGUI.current.stmt = StarfleetGUI.current.con.prepareStatement(
											"UPDATE CAPTAINS SET assigned_vessel = ?"+
											" WHERE captain_name = ?;");
									StarfleetGUI.current.stmt.setString(1, table.getValueAt(0, 1).toString());
									StarfleetGUI.current.stmt.setString(2, table.getValueAt(0, 0).toString());
									StarfleetGUI.current.stmt.executeUpdate();
									
									StarfleetGUI.current.reload();
									JOptionPane.showMessageDialog(null, "Starfleet updated");
								} 
								catch (SQLException e1) {
									JOptionPane.showMessageDialog(null, "Starfleet not updated");
									e1.printStackTrace();
								}						
								StarfleetGUI.current.dispose();
							}
						}
						else {
							if (myValidate()) {
								try {
									StarfleetGUI.current.stmt = StarfleetGUI.current.con.prepareStatement(
											"INSERT INTO CAPTAINS (captain_name, assigned_vessel)" +
											" VALUES (?, ?);"							
									);
									StarfleetGUI.current.stmt.setString(1, table.getValueAt(0, 0).toString());
									if (table.getValueAt(0, 1) != null) StarfleetGUI.current.stmt.setString(2, table.getValueAt(0, 1).toString());
									else StarfleetGUI.current.stmt.setString(2, null);
									StarfleetGUI.current.stmt.executeUpdate();
									StarfleetGUI.current.reload();
									JOptionPane.showMessageDialog(null, "Captain added to DataBase");
								} 
								catch (SQLException e1) {
									JOptionPane.showMessageDialog(null, "Exception: Captain not added to DataBase");
									e1.printStackTrace();
								}						
								StarfleetGUI.current.dispose();
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EditCaptain.current.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	

	private boolean myValidate() {
		if(!isAssign) {
			try {
				StarfleetGUI.current.stmt = StarfleetGUI.current.con.prepareStatement("SELECT * FROM CAPTAINS WHERE captain_name = ?");
				StarfleetGUI.current.stmt.setString(1, (String)table.getValueAt(0, 0));
				ResultSet rs = StarfleetGUI.current.stmt.executeQuery();
				if (rs.first()) {
					JOptionPane.showMessageDialog(null, "This Captain is already in the Database");
					return false;
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Database inaccessible");
				return false;
			}		
		}
		else
		{
			if(!isNonCaptain(table.getValueAt(0, 0))) {
				JOptionPane.showMessageDialog(null, "Invalid Captain");
				return false;				
			}
			if(!isFromFleet(table.getValueAt(0, 1))) {
				JOptionPane.showMessageDialog(null, "Invalid vessel: vessel not from the Starfleet");
				return false;				
			}
		}
		return true;
	}	
	
	static boolean isNonCaptain(Object s) {
		if (s==null){return false; }
		try{
			 if (s.toString() != "") { return true; }
			 return false;
		}
		catch (Exception e){
			return false;
		}
	}
	
	static boolean isFromFleet(Object s) {
		if (s==null){ return false; }
		try{
			StarfleetGUI.current.stmt = StarfleetGUI.current.con.prepareStatement("SELECT vessel_name FROM SHIPS");
			ResultSet rs = StarfleetGUI.current.stmt.executeQuery();
			while(rs.next())
			{
				if (s.toString() == rs.toString()) return false;
			}
			return true;
		}
		catch (Exception e){
			return false;
		}
	}

}
