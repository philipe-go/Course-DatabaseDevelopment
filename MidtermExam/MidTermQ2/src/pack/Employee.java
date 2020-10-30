package pack;

public class Employee implements Comparable<Employee> {
	private int _id;
	private String _name;
	private String _givenName;
	private double _salary;
	
	protected void Set_id(int id) { if (id > 0) this._id = id; else throw new ExceptionHandler(1,id); }
	protected void Set_name(String name) { if (validName(name)) this._name = name; else throw new ExceptionHandler(2,name); } 
	protected void Set_givenName(String givenName) { if(validName(givenName)) this._givenName = givenName; else throw new ExceptionHandler(3,givenName);  }
	public void Set_salary(double salary) { if (salary >=0) this._salary = salary; else throw new ExceptionHandler(4,salary); }
	
	public int Get_id() { return this._id; }
	public String Get_name() { return _name; }
	public String Get_givenName() { return _givenName; }
	public double Get_salary() { return _salary; }
	
	public Employee(int id, String name, String givenName)
	{
		Set_id(id);
		Set_name(name);
		Set_givenName(givenName);
	}
	
	public Employee(int id, String name, String givenName, double salary)
	{
		Set_id(id);
		Set_name(name);
		Set_givenName(givenName);
		Set_salary(salary);
	}
	
	@Override
	public String toString()
	{
		return "Employee [id: "+this._id+" - name: "+this._name+" "+this._givenName+" - salary = "+this._salary+" ]";
	}	
	
	@Override
	public int compareTo(Employee o) {
		return this._id - o.Get_id();
	}
	
	///////
	
	private boolean validName(String name) {
		for (char c : name.toCharArray()) 
		{
			if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == ' ') || (c == '-'))) return false;
		}
		return true;
	}
}
