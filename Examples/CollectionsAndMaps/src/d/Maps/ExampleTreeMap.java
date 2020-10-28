package d.Maps;

import java.util.*;

public class ExampleTreeMap {

	public static void main(String[] args) {
		
		Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer s1, Integer s2) {
                return -1*(s1 - s2);
            }
        };	
		
//      TreeMap<Integer, String> myMap = new TreeMap<Integer, String>();
//		TreeMap<Integer, String> myMap = new TreeMap<Integer, String>(integerComparator);
		TreeMap<Integer, String> myMap = new TreeMap<Integer, String>((s1,s2)->-1*(s1 - s2));
		
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
