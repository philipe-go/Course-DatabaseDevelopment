package pack;

import java.io.*;
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
}
