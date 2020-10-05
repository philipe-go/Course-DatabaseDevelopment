package a.Sets;
import java.util.*;

public class ExampleLinkedHashSet {
	public static void main(String[] args)
	{
		LinkedHashSet<String> mySet = new LinkedHashSet<String>();
		
		mySet.add("first");
		mySet.add("second");
		mySet.add("fourth");
		mySet.add("fourth"); //<<<<< Does not include repetition
		
		System.out.println(mySet.size());
		
		Iterator<String> iter = mySet.iterator(); //<<<<<< ITERATOR implementation
		
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ; ");
		}
		System.out.println();		
	}
}
