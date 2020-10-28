package pack;

import java.util.Arrays;

public class Strings1 {

	public static void main(String[] args) {
		
		String s = "Hall".concat("o").replace('a','e');
		System.out.println(s);
		s=s+ " World!";
		System.out.println(s);
		
		char[] c = s.toCharArray();   // converting string to array of char 
		
		System.out.println(c.length);  
		System.out.println(s.length());
		
		// Converting array of char to String 
		
		String s2 = c.toString();  // the address of c, not the content
		System.out.println(s2);
		
		s2 = Arrays.toString(c);  // the array c is presented as a string, but not converted to a string
		System.out.println(s2);
		
		s2 = new String(c);      // the array c is converted to a string
		System.out.println(s2);
		
		s2 = String.valueOf(c);  // the array c is converted to a string
		System.out.println(s2);
		
	}

}
