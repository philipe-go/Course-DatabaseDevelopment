package db1_MySQL;

import java.sql.*;

public class InsertRows {

	public static void main(String[] args) {
		try {
			 //
			 // For old releases of the driver 
			 // Class.forName("com.mysql.jdbc.Driver");
			 // 
			 // For newer releases of the driver
		     // Class.forName("com.mysql.cj.jdbc.Driver");
			 // 
			 // Today it is, in general, no longer needed.
		     //
			 String url = "jdbc:mysql://localhost:3306/EMP";
			 Connection con = DriverManager.getConnection(url,"root", "root");
			 //
			 con.setAutoCommit(false);  // the four executeUpdate succeed or none
			 //
			 Statement stmt = con.createStatement();
			 stmt.executeUpdate(
					 "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
					 "VALUES (2, 'Allen', 25, 'Texas', 15000.00 )");
			 stmt.executeUpdate(
					 "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
			         "VALUES (1, 'Paul', 32, 'California', 20000.00 )");
			 stmt.executeUpdate(
					 "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
					 "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 )");
			 stmt.executeUpdate(
					 "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
					 "VALUES (4, 'Mark', 25, 'Richmond', 65000.00 ),"
					 +      "(5, 'John', 28, 'France', 80000.00)");	
			 //
			 con.commit();  // end of transaction. 
			 stmt.close();	  
			 con.close();		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
