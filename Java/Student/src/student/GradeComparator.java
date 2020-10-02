package student;

import java.util.Comparator;

public class GradeComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		int r;
		if (o1.GetGrade()>o2.GetGrade()) r=1;
		else if (o1.GetGrade() == o2.GetGrade()) r = 0;
		else if (o1.GetGrade() < o2.GetGrade()) r=-1;
		else r=0;

		return r;
	}
}
