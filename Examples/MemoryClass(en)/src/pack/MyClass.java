package pack;

import java.util.*;

public class MyClass {
	
	private String s;
	
	public MyClass(String s) {
		this.s = s; 
		memory.add(this);
	}	
	
	private static List<MyClass> memory = new ArrayList<MyClass>();

	public static List<MyClass> getMemory() {
		return memory;
	}
	
	public static boolean removeFromMemory(MyClass o ) {
		return memory.remove(o); 
	}
	
	@Override
	public String toString() {
		return "[ "+s+" ]";
	}

}
