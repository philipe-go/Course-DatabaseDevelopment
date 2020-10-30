package pack;

import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Employee e1 = new Employee(1, "Ddd", "Ddd");
		Employee e2 = new Employee(2, "Aaa", "Aaa", 1000.00);
		e1.Set_salary(1500.00);
		
		System.out.println(e1);
		System.out.println(e2);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(new Employee(5, "Ppp", "Ppp", 1200.00));
		employees.add(new Employee(3, "Ccc", "Ccc", 1100.00));
		employees.add(new Employee(9, "Zzz", "Zzz", 1900.00));

		System.out.println("\n===List initial state====\n");
		for (Employee e : employees) System.out.println(e);
		
		System.out.println("\n===List sorted by id====\n");
		Collections.sort(employees);
		for (Employee e : employees) System.out.println(e);
		
		System.out.println("\n===List sorted by name====\n");
		Collections.sort(employees, new NameSorter());
		for (Employee e : employees) System.out.println(e);
		
		System.out.println("\n===List sorted by salary====\n");
		Collections.sort(employees, new SalarySorter());
		for (Employee e : employees) System.out.println(e);
				
		System.out.println("=====Exceptions=====");
		//Employee e30 = new Employee(0, "Except", "Id");
		//Employee e40 = new Employee(3, "//", "ExceptName", 10.5);
		//Employee e50 = new Employee(4, "Except GivenName", "??");
		//Employee e60 = new Employee(3, "Except", "Salary", -100.00);		
	}
}
