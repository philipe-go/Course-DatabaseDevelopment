package pack;

import java.util.Arrays;

public class StringFirst {
	public static void main(String[] args)
	{
		String s = "Hallo".replace('a', 'e');
		System.out.println(s);
		s +=" World!";
		System.out.println(s);
		
		//Convert String to Array of Char
		
		char[] c = s.toCharArray(); 
		
		System.out.println(c);
		System.out.println(c.length);
		System.out.println(s.length());
		
		
		//Convert array of char to String
		String s2 = Arrays.toString(c); //this way it converts to String of strings
		System.out.println(s2);
		
		s2 = new String(c); //this way the array of char is converted correctly to String
		System.out.println(s2);
		
		s2 = String.valueOf(c); //this way c is converted on a static method not constructor
		System.out.println(s2);
	}
}
