package student;

public class Student implements Comparable<Student>{
	private int id;
	private String name;
	private String givenName;
	private double grade;
	
	public Student(int id, String name, String givenName) {	
		setId(id);
		setName(name);
		setGivenName(givenName);
	}

	public Student(int id, String name, String givenName, double grade) {
		setId(id);
		setName(name);
		setGivenName(givenName);
		setGrade(grade);
	}

	private boolean isValidName(String n) {
		boolean r = true;
		for (char c : n.toCharArray())
			// if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ') && (c != '-'))
			if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == ' ') || (c == '-')))
				r = false;
		return r;
	}
	
	public int getId() {
		return id;
	}

	protected void setId(int id) {
		if(id<=0) {
			throw new StudentDataException(1,id);
		}
		else {
			this.id = id;
		}
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		if (!isValidName(name)) {
			throw new StudentDataException(2,name);
		}
		else {
			this.name = name;
		}
	}

	public String getGivenName() {
		return givenName;
	}

	protected void setGivenName(String givenName) {
		if (!isValidName(givenName)) {
			throw new StudentDataException(3,givenName);
		}
		else {
			this.givenName = givenName;
		}
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		if(grade<0) {
			throw new StudentDataException(4,grade);
		}
		else {
			this.grade = grade;
		}
	}
	
	public Student withGrade(double grade) {
		this.setGrade(grade);
		return this;		
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", givenName=" + givenName + ", grade=" + grade + "]";
	}

	@Override
	public int compareTo(Student s) {		
		return this.id - s.id;
	}
	
	
	
}
