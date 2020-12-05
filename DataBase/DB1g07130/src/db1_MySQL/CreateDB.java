package db1_MySQL;

import java.sql.*;

public class CreateDB {

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
			String url = "jdbc:mysql://localhost:3306/";
			Connection con = DriverManager.getConnection(url, "root", "root");  // connect to database server
			//
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);
			//
			Statement stmt = con.createStatement();                            // create a statement
			stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS EMP");           // create database EMP
			//
			stmt.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
