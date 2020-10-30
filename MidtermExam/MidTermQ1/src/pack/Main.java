package pack;

public class Main {
	public static void main(String[] args)
	{
		Captain cpt1 = new Captain("Jean-Luc Picard");
		Captain cpt2 = new Captain("Benjamin Sisco");
		Captain cpt3 = new Captain("Katherine Janeway");
		
		Ship ship1 = new Ship(VesselType.Ship, "Enterprise");
		Ship ship2 = new Ship(VesselType.Stellar_Base, "Deep Space 9");
		Ship ship3 = new Ship(VesselType.Ship, "Voyageur");
		
		for(Ship s : Starfleet.m_Ships)
			System.out.println("Ship: " + s.get_Name() + " - Captain: " + s.get_CaptainName());
		System.out.println();
		for(Captain c : Starfleet.m_Captains)
			System.out.println("Captain: " + c.get_Name() + " - Ship: " + c.get_ShipName());
		System.out.println();
		
		System.out.println("=====Assignments=====");
		Starfleet.AssignVessel(cpt1, ship1);
		Starfleet.AssignVessel(cpt2, ship2);
		Starfleet.AssignVessel(cpt3, ship3);
		
		for(Ship s : Starfleet.m_Ships)
			System.out.println("Ship: " + s.get_Name() + " - Captain: " + s.get_CaptainName());
		System.out.println();
		for(Captain c : Starfleet.m_Captains)
			System.out.println("Captain: " + c.get_Name() + " - Ship: " + c.get_ShipName());
		System.out.println();
		
		System.out.println("=====Assignments Removed=====");

		Starfleet.RemoveAssignment(ship3);
		Starfleet.RemoveAssignment(cpt2);
		
		for(Captain c : Starfleet.m_Captains)
			System.out.println("Captain: " + c.get_Name() + " - Ship: " + c.get_Ship().get_Name());
		System.out.println();
		for(Ship s : Starfleet.m_Ships)
			System.out.println("Ship: " + s.get_Name() + " - Captain: " + s.get_Captain().get_Name());

	}
}
