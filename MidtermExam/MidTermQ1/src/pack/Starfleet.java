package pack;

import java.util.*;

public class Starfleet {
	public static List<Ship> m_Ships = new ArrayList<Ship>();
	public static List<Captain> m_Captains = new ArrayList<Captain>();
	
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
}
