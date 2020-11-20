package db1_MySQL;

import java.sql.*;


public class CreateDB {

	public static void main(String[] args) {
		try 
		{
			//Class.forName("com.mysql.cj.");
			
			String url = "jdbc:mysql://localhost:3306/";
			Connection con = DriverManager.getConnection(url, "root", "root"); //connect to the database
			
			Statement stmt = con.createStatement(); //create the statement for the query
			stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS EMP"); //create the database using the statement query name EMP
			
			stmt.close();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
