package db1_MySQL;

import java.sql.*;

public class CreateDBtables {

		public static void main(String[] args) {
			
			String tableName = "COMPANY";
			
			try 
			{
				String url = "jdbc:mysql://localhost:3306/EMP";
				Connection con = DriverManager.getConnection(url, "root", "root"); //connect to the database server
				
				Statement stmt = con.createStatement(); //create the statement for the query
				stmt.executeUpdate(
						"CREATE TABLE IF NOT EXISTS "+ tableName +
						" (ID INT PRIMARY KEY NOT NULL,"
						+ " NAME TEXT NOT NULL,"
						+ " AGE INT NOT NULL,"
						+ " ADDRESS CHAR(50),"
						+ " SALARY REAL)"
						); //create the database using the statement query name EMP
				
				stmt.close();
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}
}
