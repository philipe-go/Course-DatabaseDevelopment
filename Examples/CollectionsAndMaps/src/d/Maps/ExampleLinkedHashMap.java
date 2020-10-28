package d.Maps;

import java.util.*;

public class ExampleLinkedHashMap {

	public static void main(String[] args) {
		
		LinkedHashMap<Integer, String> myMap = new LinkedHashMap<Integer, String>();
		
		myMap.put(3,"First");
		myMap.put(5, "Second");
		myMap.put(1, "Fourth");
		
		System.out.println("myMap size: "+ myMap.size());
		
        Iterator<Integer>myIter= myMap.keySet().iterator();
		
		System.out.print("Elements of myMap: ");
		
		while(myIter.hasNext()){
			System.out.print(myMap.get(myIter.next())+" ; ");
		}
		System.out.println();

		Iterator<String>myIter2= myMap.values().iterator();
		
		System.out.print("Elements of myMap: ");
		
		while(myIter2.hasNext()){
			System.out.print(myIter2.next()+" ; ");
		}
		System.out.println();

	}

}
