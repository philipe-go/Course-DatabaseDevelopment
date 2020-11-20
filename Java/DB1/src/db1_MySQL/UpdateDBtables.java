package db1_MySQL;

import java.sql.*;

public class UpdateDBtables {

	public static void main(String[] args) {
		String tableName = "COMPANY";
		
		try 
		{
			String url = "jdbc:mysql://localhost:3306/EMP";
			Connection con = DriverManager.getConnection(url, "root", "root"); //connect to the database server
			
			PreparedStatement stmt = con.prepareStatement("UPDATE ? set SALARY = ? WHERE id = ?"); //create the statement for the query
			stmt.setString(1,tableName);
			stmt.setString(2,"3000");
			stmt.setString(3,"1");
			
			con.commit();
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
