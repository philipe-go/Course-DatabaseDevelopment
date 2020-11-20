package e.serialization;

public class Employee implements java.io.Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	   private String name;
	   private String address;
	   private transient int SSN;
	   private int number;
	   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSSN() {
		return SSN;
	}
	public void setSSN(int sSN) {
		SSN = sSN;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	   
	   
}
