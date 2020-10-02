package pack;

public class Friend {
	private String name;
	private int age;
	
	public Friend(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public String GetName()
	{
		return this.name;
	}
	public int GetAge()
	{
		return this.age;
	}
	public void SetName(String name)
	{
		this.name = name;
	}
	public void SetAge(int age)
	{
		this.age = age;
	}

}
