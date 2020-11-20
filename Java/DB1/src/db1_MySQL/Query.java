package db1_MySQL;

import java.sql.*;

public class Query {

	public static void main(String[] args) {
		String tableName = "COMPANY";
		
		try 
		{
			String url = "jdbc:mysql://localhost:3306/EMP";
			Connection con = DriverManager.getConnection(url, "root", "root"); //connect to the database server
			
			Statement stmt = con.createStatement(); //create the statement for the query
			ResultSet rs = stmt.executeQuery("SELECT * FROM "+tableName); //this is not safe due to SQL INJECTION
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				float salary = rs.getFloat("salary");
				
				System.out.println("ID: "+id+" | Name: "+name+" | Age: "+age+" | Address: "+address+" | Salary: "+salary);
			}
			
			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
