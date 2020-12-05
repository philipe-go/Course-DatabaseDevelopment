package db1_MySQL;

import java.sql.*;

public class DropDB {

	public static void main(String[] args) {
		try {
			 String url = "jdbc:mysql://localhost:3306/EMP";   // for DROP DATABASE, EMP may be here or not
			 Connection con = DriverManager.getConnection(url,"root", "root");
			 //
			 Statement stmt = con.createStatement();
			 stmt.executeUpdate("DROP DATABASE IF EXISTS EMP");
			 stmt.close();
			 con.close();	
	    } 
		catch (Exception e) {
			e.printStackTrace();
		}			
	}

}
