package main;

import java.util.*;

import student.*;

public class Main {

	public static void main(String[] args) {
		
		Student s1 = new Student(1, "Tremblay", "Pierre");
		s1.setGrade(83.5);
		
		System.out.println(s1);
		
		System.out.println(new Student(46, "Smith", "John").withGrade(90.0));

		System.out.println("List of Students");
		
		List<Student> list = new ArrayList<Student>();
		
		list.add(s1);		
		list.add(new Student(44, "Smith", "Anne").withGrade(85.3));
		list.add(new Student(45, "Smith", "Anne").withGrade(85.3));
		list.add(new Student(28, "Barros", "Renan", 81.4));
		list.add(new Student(17, "Picard","Jean", 90.5));
		list.add(new Student(19, "Brown","Mary", 88.5));
		
		System.out.println("ArrayList is by default sorted by the inclusion order");
		for(Student a: list)
			System.out.println(a);
		System.out.println();
		
		System.out.println("ArrayList sorted by id (default order of the class Student)");
		Collections.sort(list); 
		for(Student a: list)
			System.out.println(a);
		System.out.println();
		
		System.out.println("ArrayList sorted by name");
		Collections.sort(list, new NameComparator()); 
		for(Student a: list)
			System.out.println (a);
		System.out.println();

		System.out.println("ArrayList sorted by grade");
		Collections.sort(list, new GradeComparator()); 
		for(Student a: list)
			System.out.println (a);
		System.out.println();
		
	}

}
