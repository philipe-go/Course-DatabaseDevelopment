package db1_MySQL;

import java.sql.*;

public class DropTable {

	public static void main(String[] args) {
		try {
			 String url = "jdbc:mysql://localhost:3306/EMP";
			 Connection con = DriverManager.getConnection(url,"root", "root");
			 //
			 Statement stmt = con.createStatement();
			 stmt.executeUpdate("DROP TABLE IF EXISTS COMPANY");
			 stmt.close();
			 con.close();	
	    } 
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
