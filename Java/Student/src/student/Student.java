package student;

//------------>>> implementation of the Interface Comparable

public class Student implements Comparable<Student> {
	private int id;
	private String name;
	private String givenName;
	private double grade;
	
	public Student(int id, String name, String givenName)
	{
		SetId(id);
		SetName(name);
		SetGivenName(givenName);
	}
	
	public Student(int id, String name, String givenName, double grade)
	{
		//super(); //Is the constructor of the parent class
		SetId(id);
		SetName(name);
		SetGivenName(givenName);
		SetGrade(grade);
	}
	
	private boolean isValidName(String n)
	{
		boolean r = true;
		for (char c : n.toCharArray())
			if (!(c>='a' &&c<='z' || c >= 'A' && c <= 'Z' || c == ' ' || c == '-')) r = false;
		return r;
	}

	public int GetId() {
		return id;
	}

	public void SetId(int id) {
		if (id <= 0) { throw new StudentDataException(1,id); }
		else { this.id = id; }
	}

	public String GetName() {
		return name;
	}

	public void SetName(String name) {
		if (!isValidName(name)) { throw new StudentDataException(2,name);}
		else { this.name = name; }
	}

	public String GetGivenName() {
		return givenName;
	}

	public void SetGivenName(String givenName) {
		if (!isValidName(givenName)) {throw new StudentDataException(2,name);}
		this.givenName = givenName;
	}

	public double GetGrade() {
		return grade;
	}

	public void SetGrade(double grade) {
		if (grade<0) {throw new StudentDataException(3,grade);}
		this.grade = grade;
	}
	
	//------------>>> With works as a setter
	public Student WithGrade(double grade) {
		this.SetGrade(grade);
		return this;
	}
	
	@Override
	public String toString()
	{
		return "Student [id ="+this.id+", name = "+this.name+", Given Name = "+this.givenName+", Grade = "+this.grade;
	}
	
	@Override
	public int compareTo(Student o)
	{
		return this.id - o.id;
	}

}
