package student;

import java.util.Comparator;

public class GradeComparator  implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		int r;
		if (s1.getGrade()>s2.getGrade()) {
			r=1;
		}
		else if (s1.getGrade()==s2.getGrade()) {
			r=0;
		}
		else { // s1.getGrade()<s2.getGrade()
			r=-1;
		}
		if (r==0) {
			r=s1.getId()-s2.getId();
		}
		return r;
	}

}
