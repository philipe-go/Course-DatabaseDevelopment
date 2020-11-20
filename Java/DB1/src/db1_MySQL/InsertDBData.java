package db1_MySQL;

import java.sql.*;

public class InsertDBData {

	public static void main(String[] args) {
		
		String tableName = "COMPANY";
		
		try 
		{
			String url = "jdbc:mysql://localhost:3306/EMP";
			Connection con = DriverManager.getConnection(url, "root", "root"); //connect to the database server
			
			con.setAutoCommit(false);
			
			Statement stmt = con.createStatement(); //create the statement for the query
			stmt.executeUpdate(
					"INSERT INTO "+ tableName + " (ID,NAME,AGE,ADDRESS,SALARY) "+
					"VALUES (1, 'Philipe', 35, 'BRAZIL', 1000.0)"
					);
			
			stmt.executeUpdate(
					"INSERT INTO "+tableName+" (ID,NAME,AGE,ADDRESS,SALARY) "+
					"VALUES (2, 'Lulis', 30,'CANADA', 3500.0), (3, 'Popoto', 1, 'QUEBEC', 500.0)"
					);

			con.commit();
			
			stmt.close();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
