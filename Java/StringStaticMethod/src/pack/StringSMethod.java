package pack;

public class StringSMethod {
	public static void main(String[] args)
	{

		char[] c = {'a','b','c'}; 
		
		System.out.println(c);
		System.out.println(c.length);
		System.out.println(new String(c));

		
		String s = "Bonjour";
		System.out.println(s);
		System.out.println(s.valueOf(c)); //calling a static method from an object of the class (not allowed in c#)
		System.out.println(s);
	}
}
