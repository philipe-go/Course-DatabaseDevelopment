package pack;
import java.util.*;

public class Program {
	public static void main(String[] args) {
		List<Friend> list = new ArrayList<Friend>();
		list.add(new Friend("Lulu", 32));
		list.add(new Friend("Popoto", 1));
		list.add(new Friend("Guida", 62));
		list.add(new Friend("Polly", 37));
		list.add(new Friend("Clara", 8));
		
		
		
		for (Friend f : list)
			System.out.print(f.GetName()+", ");
		System.out.println();
		
		//Collection.sort(list); //Sort the list by the default order of the class Friend is not possible
		
		//---------->>>>> FUNCTIONAL INTERFACES
//		Comparator<Friend> nameComp = new Comparator<Friend>(){
//			@Override
//			public int compare(Friend f1, Friend f2) {
//				return f1.GetName().compareTo(f2.GetName());
//			}
//		};
		
		//---------->>>>>> LAMBDA EXPRESSION
		Collections.sort(list, (f1,f2)->f1.GetName().compareTo(f2.GetName()));

		for (Friend f : list)
			System.out.print(f.GetName()+", ");
		System.out.println();		
		
		Collections.sort(list, (f1,f2)->f1.GetAge() - f2.GetAge());

		for (Friend f : list)
			System.out.print(f.GetName()+", ");
		System.out.println();	
	}
}
