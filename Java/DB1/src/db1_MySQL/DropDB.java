package db1_MySQL;

import java.sql.*;

public class DropDB {
	public static void main(String[] args) {
			
		try 
		{
			String url = "jdbc:mysql://localhost:3306/EMP"; //you don't need to put the EMP here as you will delete this database
			Connection con = DriverManager.getConnection(url, "root", "root");
			
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("DROP DATABASE EMP"); //if you put EMP above you don't need to put the IF EXISTS
			
			stmt.close();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
