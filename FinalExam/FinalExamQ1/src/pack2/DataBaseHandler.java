package pack2;

import java.sql.*;

public class DataBaseHandler {
	
	//THOSE FUNCTIONS WHERE ALSO DEFINED IN THE ../DBScript.sql as a script to run in the database directly
	
	public static void CreateDataBase()
	{
		try {
			String url = "jdbc:mysql://localhost:3306/";
			Connection con = DriverManager.getConnection(url, "root", "root");

			PreparedStatement stmt = con.prepareStatement("CREATE DATABASE IF NOT EXISTS STARFLEET"); 
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
			
			System.out.println();
			System.out.println("DataBase created successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void CreateTables()
	{
		try {
			 String url = "jdbc:mysql://localhost:3306/STARFLEET?allowMultiQueries=true";                     
			 Connection con = DriverManager.getConnection(url, "root", "root");
			 
			 PreparedStatement stmt = con.prepareStatement(	
					 "CREATE TABLE IF NOT EXISTS SHIPS " +
					 "(vessel_name VARCHAR(50) PRIMARY KEY  NOT NULL," +
					 " vessel_type VARCHAR(20)			    NOT NULL); "+
					 "CREATE TABLE IF NOT EXISTS CAPTAINS " +
					 "(captain_name VARCHAR(50) NOT NULL, " + 
					 "assigned_vessel VARCHAR(50), "+
					 "PRIMARY KEY(captain_name), "+
					 "FOREIGN KEY(assigned_vessel) REFERENCES SHIPS(vessel_name));");              
			 stmt.executeUpdate();	

			 stmt.close();
			 con.close();
			 
			System.out.println();
			System.out.println("Tables created successfully");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
