package pack;

public class Captain {
	private String _name;
	private Ship _ship;
	private String _shipName;
	
	public String get_Name() { return _name; } 
	public String get_ShipName() { return _shipName; }
	public Ship get_Ship() { return _ship; }
	public void set_Ship(Ship ship) { _ship = ship; _shipName = ship.get_Name(); }
		
	public Captain(String name)
	{
		this._name = name;
		this._ship = null;
		this._shipName = " ";
		Starfleet.m_Captains.add(this);
	}
}
