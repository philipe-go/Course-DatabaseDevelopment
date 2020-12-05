package db1_MySQL;

import java.sql.*;

public class CreateTables {

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
			 String url = "jdbc:mysql://localhost:3306/EMP";                     // url now includes the database
			 Connection con = DriverManager.getConnection(url, "root", "root");  // connect to server and to the database
			 //
			 Statement stmt = con.createStatement();                            
			 stmt.executeUpdate(
					 "CREATE TABLE IF NOT EXISTS COMPANY " +
			         "(ID INT PRIMARY KEY     NOT NULL," +
			         " NAME           TEXT    NOT NULL, " + 
			         " AGE            INT     NOT NULL, " + 
			         " ADDRESS        CHAR(50), " + 
			         " SALARY         REAL)");	
			 //		 
		     //   BY DEFAULT: We can not have two CREATE in a single stmt.executeUpdate()
			 //   To allow the execution of multiple commands in a single 
			 //   executeUpdate the connection url must be 
			 //   url = "jdbc:mysql://localhost:3306/EMP?allowMultiQueries=true";	
			 //
			 /*      stmt.executeUpdate(
							 "CREATE TABLE COMPANY " +
							 "(ID INT PRIMARY KEY     NOT NULL," +
							 " NAME           TEXT    NOT NULL, " + 
							 " AGE            INT     NOT NULL, " + 
							 " ADDRESS        CHAR(50), " + 
							 " SALARY         REAL); "+
							 "CREATE TABLE COMPANY2 " +
							 "(ID INT PRIMARY KEY     NOT NULL," +
							 " NAME           TEXT    NOT NULL, " + 
							 " AGE            INT     NOT NULL, " + 
							 " ADDRESS        CHAR(50), " + 
							 " SALARY         REAL); "
							 );
			 */		
			 stmt.close();
			 con.close();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}


	}

}
