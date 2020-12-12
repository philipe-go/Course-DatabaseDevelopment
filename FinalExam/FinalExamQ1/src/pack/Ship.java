package pack;

public class Ship implements java.io.Serializable {
	
	private static final long serialVersionUID = 2L;
	
	private VesselType _type;
	private String _name;
	private Captain _captain;
	private String _captainName;
	

	public VesselType get_Type() { return _type; 	}
	public String get_Name() { return _name; }
	public String get_CaptainName() { return _captainName; }
	public Captain get_Captain() { return _captain; }
	
	public void set_Captain(Captain cpt) { _captain = cpt; _captainName = cpt.get_Name(); }	
		
	public Ship(VesselType type, String name)
	{
		this._type = type;
		this._name = name;
		this._captainName = " ";
		this._captain = null;
		Starfleet.m_Ships.add(this);
	}
}
