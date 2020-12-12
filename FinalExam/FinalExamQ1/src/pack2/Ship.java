package pack2;

public class Ship implements java.io.Serializable {
	
	private static final long serialVersionUID = 2L;
	
	private VesselType _type;
	private String _name;
	private Captain _captain;
	

	public VesselType get_Type() { return _type; }
	public String get_TypeString() { return _type.toString(); }
	public String get_Name() { return _name; }
	public Captain get_Captain() { return _captain; }
	
	public void set_Captain(Captain cpt) { _captain = cpt; }	
		
	public Ship(VesselType type, String name)
	{
		this._type = type;
		this._name = name;
		this._captain = null;
		Starfleet.m_Ships.add(this);
	}
	
	public Ship(String type, String name)
	{
		switch(type){
			case "stellar_base": {this._type = VesselType.Stellar_Base; }break;
			case "ship": {this._type = VesselType.Stellar_Base; }break;
			default : {this._type = VesselType.None; }break;
		}
		this._name = name;
		this._captain = null;
		Starfleet.m_Ships.add(this);
	}
}
