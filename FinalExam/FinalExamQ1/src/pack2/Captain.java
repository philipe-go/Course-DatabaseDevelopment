package pack2;

public class Captain implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String _name;
	private Ship _ship;
	
	public String get_Name() { return _name; } 
	public Ship get_Ship() { return _ship; }
	public String get_ShipName() { return _ship.get_Name(); }
	public void set_Ship(Ship ship) { _ship = ship; }
		
	public Captain(String name)
	{
		this._name = name;
		this._ship = null;
		Starfleet.m_Captains.add(this);
	}
}
