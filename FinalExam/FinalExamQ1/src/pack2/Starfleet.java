package pack2;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Starfleet {
	public static ArrayList<Ship> m_Ships = new ArrayList<Ship>();
	public static ArrayList<Captain> m_Captains = new ArrayList<Captain>();
	
	public static void AssignVessel(Captain cpt, Ship ship) {
		m_Captains.get(m_Captains.indexOf(cpt)).set_Ship(m_Ships.get(m_Ships.indexOf(ship)));
		m_Ships.get(m_Ships.indexOf(ship)).set_Captain(m_Captains.get(m_Captains.indexOf(cpt)));
	}
	
	public static void RemoveAssignment(Captain cpt)
	{
		AssignVessel(new Captain(" "), m_Ships.get(m_Ships.indexOf(cpt.get_Ship())));
		m_Captains.remove(cpt);
	}
	
	public static void RemoveAssignment(Ship ship)
	{
		AssignVessel(m_Captains.get(m_Captains.indexOf(ship.get_Captain())), new Ship(VesselType.None, " "));
		m_Ships.remove(ship);
	}
	
	public static void SaveList(String listName)
	{
		try {
	         FileOutputStream fo = new FileOutputStream(listName+".dat");
	         ObjectOutputStream out = new ObjectOutputStream(fo);
	         out.writeObject(m_Captains);
	         out.writeObject(m_Ships);
	         out.close();
	         fo.close();
	         System.out.println("Data serialization ended successfully - saved in "+listName+".dat");  
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}
	
	public static void ReadList(String listName)
	{
		try {
	         FileInputStream fi = new FileInputStream(listName+".dat");
	         ObjectInputStream in = new ObjectInputStream(fi);
	           
	         m_Captains.clear();
	         m_Ships.clear();
	         
	         while (fi.available()>0) {	         
	        	 if (in.readObject() instanceof Captain) m_Captains.add((Captain) in.readObject());
	        	 else m_Ships.add((Ship) in.readObject());
	         }
	         in.close();
	         fi.close();
	         
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Classes not found");
	         c.printStackTrace();
	         return;
	      }
	}
	
	
	public static void InsertData()
	{
		try {

			 String url = "jdbc:mysql://localhost:3306/STARFLEET";
			 Connection con = DriverManager.getConnection(url,"root", "root");
			 
			 con.setAutoCommit(false);
			 
			 for (Ship ship : m_Ships)
			 {
				 PreparedStatement stmt = con.prepareStatement(
						 "INSERT INTO SHIPS (VESSEL_NAME, VESSEL_TYPE) " +
						 "VALUES (?, ?)");
				  stmt.setString(1,ship.get_Name());
				  stmt.setString(2,ship.get_TypeString());
				  stmt.executeUpdate();	
				  stmt.close();
			 }
			 
			 for (Captain cpt : m_Captains)
			 {
				 PreparedStatement stmt = con.prepareStatement(
						 "INSERT INTO CAPTAINS (captain_name, assigned_vessel) " +
						 "VALUES (?, ?)");
				  stmt.setString(1,cpt.get_Name());
				  stmt.setString(2,cpt.get_ShipName());
				  stmt.executeUpdate();	
				  stmt.close();
			 }
			 
			 con.commit();
			 con.close();	
			 
			 System.out.println();
			 System.out.println("Data inserted successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ClearLists()
	{
		m_Captains.clear();
		m_Ships.clear();
	}
	
	public static void ReadData()
	{
		try {
			 String url = "jdbc:mysql://localhost:3306/STARFLEET";
			 Connection con = DriverManager.getConnection(url,"root", "root");
			 
			 PreparedStatement stmt = con.prepareStatement("SELECT * FROM CAPTAINS");
			 ResultSet rs = stmt.executeQuery();
			 
			ClearLists();
			 while (rs.next()) {
		         String  name = rs.getString("CAPTAIN_NAME");
		         Captain a_Captain = new Captain(name);
		         m_Captains.add(a_Captain);
		     }

			 
			 PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM SHIPS");
			 ResultSet rs2 = stmt2.executeQuery();
			
			 while (rs2.next()) {
		         String  name = rs2.getString("VESSEL_NAME");
		         String type = rs2.getString("VESSEL_TYPE");
		         Ship a_Ship = new Ship(type, name);
		         m_Ships.add(a_Ship);
		     }
		 
			 stmt.close();
		     stmt2.close();
			 rs.close();
			 rs2.close();
		     con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
