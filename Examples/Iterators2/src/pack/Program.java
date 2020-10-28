package pack;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		
		// In a list of 3 elements, the iterator has 4 positions
		//
		// 1. before the first element
		// 2.  before the second element  =  after the first element
		// 3. before the third element  = after the second element
		// 4. after the third element
        //
		
		List<String> myList =new ArrayList<String>();
		
		myList.add("A");
		myList.add("B");
		myList.add("C");
		
		Iterator<String> it = myList.iterator();
		
		int i=0;
		while (it.hasNext()) {
			System.out.println("Iterator before the element whose index is: "+i);
			System.out.println("Ready to read the element whose index is: "+i);
			System.out.println("element = " + it.next());
			i++;
		}
		System.out.println("i ends with the value: "+i);	
		System.out.println("Iterator after the element whose index is: "+ (i-1));

	}

}
