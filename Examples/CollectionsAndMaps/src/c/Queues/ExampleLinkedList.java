package c.Queues;

import java.util.LinkedList;
import java.util.ListIterator;

public class ExampleLinkedList {

	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>(); 
		
		myList.add("First");
		myList.add("Second");
		myList.add("Fourth"); 
		myList.add("Fourth"); 
		
		System.out.println("myList size: "+ myList.size()); 
		
		ListIterator<String>myIter= myList.listIterator();
		
		System.out.print("Elements of myList: ");
		
		while(myIter.hasNext()){
			System.out.print(myIter.next()+" ; ");
		}
		System.out.println();
		
		System.out.println("myList size: "+ myList.size());
		
		System.out.print("Elements of myList: ");
		
		while(!myList.isEmpty()){
			System.out.print(myList.poll()+" ; ");
		}
		
		System.out.println();
		
		System.out.println("myList size: "+ myList.size());
		
	}

}
