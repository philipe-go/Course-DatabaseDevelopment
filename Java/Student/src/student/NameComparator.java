package student;

import java.util.Comparator;

//Difference Comparator and Comparable? --->>> 

public class NameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int r = o1.GetName().compareTo(o2.GetName());
		if (r == 0) { r = o1.GetGivenName().compareTo(o2.GetGivenName()); }
		if (r== 0) { r =o1.GetId()-o2.GetId();}
		return r;
	}
}
