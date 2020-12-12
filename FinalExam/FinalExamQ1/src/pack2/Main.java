package pack2;

public class Main {
	public static void main(String[] args)
	{
		Captain cpt1 = new Captain("Jean-Luc Picard");
		Captain cpt2 = new Captain("Benjamin Sisco");
		Captain cpt3 = new Captain("Katherine Janeway");
		
		Ship ship1 = new Ship(VesselType.Ship, "Enterprise");
		Ship ship2 = new Ship(VesselType.Stellar_Base, "Deep Space 9");
		Ship ship3 = new Ship(VesselType.Ship, "Voyageur");
		
		Starfleet.AssignVessel(cpt1, ship1);
		Starfleet.AssignVessel(cpt2, ship2);
		Starfleet.AssignVessel(cpt3, ship3);
		
		for(Captain c : Starfleet.m_Captains)
			System.out.println("Captain: " + c.get_Name() + " - Ship: " + c.get_Ship().get_Name());
		System.out.println();
		for(Ship s : Starfleet.m_Ships)
			System.out.println("Ship: " + s.get_Name() + " - Captain: " + s.get_Captain().get_Name());
				
		System.out.println();
		System.out.println("=====DataBase Creation=====");
		DataBaseHandler.CreateDataBase();
		
		System.out.println();
		System.out.println("=====DB Tables Creation=====");
		DataBaseHandler.CreateTables();
		
		System.out.println();
		System.out.println("=====DB Data Insertion =====");
		Starfleet.InsertData();
		
		System.out.println();
		System.out.println("=====Clear Starfleet lists=====");
		Starfleet.ClearLists();
		System.out.println(Starfleet.m_Captains);
		System.out.println(Starfleet.m_Ships);
		System.out.println("=====DB Data Read =====");
		Starfleet.ReadData();
		System.out.println(Starfleet.m_Captains);
		System.out.println(Starfleet.m_Ships);
	}
}
