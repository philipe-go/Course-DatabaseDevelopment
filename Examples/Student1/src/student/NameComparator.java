package student;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {

	public NameComparator() {
	}
	
	@Override
	public int compare(Student s1, Student s2) {
		int r= s1.getName().compareTo(s2.getName());
		if (r==0) { r= s1.getGivenName().compareTo(s2.getGivenName());}
		if (r==0) {r=s1.getId()-s2.getId();}
		return r;
	}

}
