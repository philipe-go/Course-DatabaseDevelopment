package db1_MySQL;

import java.sql.*;

public class QueryParam {

	public static void main(String[] args) {
		String tableName = "COMPANY";
		
		try 
		{
			String url = "jdbc:mysql://localhost:3306/EMP";
			Connection con = DriverManager.getConnection(url, "root", "root"); //connect to the database server
			
			//THIS WAY IS NOT SAFE DUE TO SQL INJECTION
			//Statement stmt = con.createStatement(); //create the statement for the query
			//ResultSet rs = stmt.executeQuery("SELECT * FROM "+tableName+" WHERE age > "+s1+" AND salary > "+s2);
			
			//THIS WAY IS BETTER TO AVOID SQL INJECTION WHEN USING STRING VARIABLES INSIDE A STATEMENT
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM ? WHERE age < ? AND salary < ?"); //create the statement for the query
			stmt.setString(1, tableName);
			stmt.setInt(2, "20");
			stmt.setDouble(3, "3000");
			ResultSet rs = stmt.executeQuery();
			
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
