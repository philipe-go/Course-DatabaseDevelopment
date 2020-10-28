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
		
		Set<Student> set = new TreeSet<Student>();
		set.add(new Student(1, "Tremblay", "Pierre", 83.5));
		set.add(new Student(44, "Smith", "Anne", 85.3));
		set.add(new Student(45, "Smith", "Anne", 85.3));
		set.add(new Student(28, "Barros", "Renan", 81.4));
		set.add(new Student(17, "Picard","Jean", 90.5));
		set.add(new Student(19, "Brown","Mary", 88.5));
		
		System.out.println("TreeSet is by default sorted by default order (id)");
		for(Student a: set)
			System.out.println(a);
		System.out.println();
		
		
		Set<Student> set2 = new TreeSet<Student>(new NameComparator());
		set2.add(new Student(1, "Tremblay", "Pierre", 83.5));
		set2.add(new Student(44, "Smith", "Anne", 85.3));
		set2.add(new Student(45, "Smith", "Anne", 85.3));
		set2.add(new Student(28, "Barros", "Renan", 81.4));
		set2.add(new Student(17, "Picard","Jean", 90.5));
		set2.add(new Student(19, "Brown","Mary", 88.5));
		
		System.out.println("TreeSet sorted by NameComparator()");
		for(Student a: set2)
			System.out.println(a);
		System.out.println();

		Set<Student> set3 = new TreeSet<Student>(new GradeComparator());
		set3.add(new Student(1, "Tremblay", "Pierre", 83.5));
		set3.add(new Student(44, "Smith", "Anne", 85.3));
		set3.add(new Student(45, "Smith", "Anne", 85.3));
		set3.add(new Student(28, "Barros", "Renan", 81.4));
		set3.add(new Student(17, "Picard","Jean", 90.5));
		set3.add(new Student(19, "Brown","Mary", 88.5));
		
		System.out.println("TreeSet sorted by GradeComparator()");
		for(Student a: set3)
			System.out.println(a);
		System.out.println();

	}

}
