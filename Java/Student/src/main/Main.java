package main;
import student.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student(1, "Tremblay", "Pierre");
		s1.SetGrade(83.5);
		
		System.out.println(s1.toString());
		
		System.out.println(new Student(46,"Smith", "John").WithGrade(90));
		
		System.out.println("List of Students");
		
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(new Student(66,"Smith", "John").WithGrade(90));
		list.add(new Student(76,"Lllll", "Ppp").WithGrade(70));
		list.add(new Student(26,"Kkkkk", "Ddd").WithGrade(80));
		list.add(new Student(16,"Cccc", "Abc").WithGrade(60));
		list.add(new Student(56,"Aaaa", "Bbb").WithGrade(85));
		
		System.out.println();
		
		System.out.println("Array With no sort");
		
		for(Student a : list)
			System.out.println(a);
		
		System.out.println();
		
		
		System.out.println("Array sorted by ID");
		Collections.sort(list);
		
		for(Student a : list)
			System.out.println(a);
		
		System.out.println();
		
		System.out.println("Array sorted by NAME");
		Collections.sort(list, new NameComparator());
		for(Student a : list)
			System.out.println(a);
		
		System.out.println();
		
		System.out.println("Array sorted by GRADE");
		Collections.sort(list, new GradeComparator());
		for(Student a : list)
			System.out.println(a);
		
		System.out.println();
		
	}
}
