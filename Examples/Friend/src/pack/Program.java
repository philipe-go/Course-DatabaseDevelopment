package pack;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		List<Friend> list = new ArrayList<Friend>();
		list.add(new Friend("Pierre", 29));
		list.add(new Friend("Anne", 23));
		list.add(new Friend("Renan", 40));
		list.add(new Friend("Jean", 25));
		list.add(new Friend("Marie", 23));
		
		for(Friend a: list)
			System.out.print(a.getName() + ", ");
		System.out.println();
		
		//Collections.sort(list); // Sort the list by the default order of the class Friend is not possible.

//		Comparator<Friend> nc = new Comparator<Friend>(){
//			@Override
//			public int compare (Friend f1, Friend f2) {
//				return f1.getName().compareTo(f2.getName());
//			};
//		};
		
		Collections.sort(list,(f1,f2)->f1.getName().compareTo(f2.getName()) ); 
		for(Friend a: list)
			System.out.print(a.getName() + ", ");
		System.out.println();

		Collections.sort(list, (f1,f2)->f1.getAge() - f2.getAge() );
		for(Friend a: list)
			System.out.print(a.getName() +" : "+ a.getAge() + ", ");

	
	}
}
