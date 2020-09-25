package pack;

public class StringsProgram {
	public static void main(String[] args)
	{
		String a = "Bonjour";
		String b = "Bonjour";
		String c;
		c=a;
		String d = new String("Bonjour");
		System.out.println("a==b ? "+(a==b)+" >> because of literals, a and b will point to the same heap memory location");
		System.out.println("a==c ? "+(a==c)+" >> because of literals, a and c will point to the same heap memory location");
		System.out.println("a==d ? "+(a==d)+" >> in this case d is called with a constructor to create a new object");
		System.out.println("a.equals(b) ? "+(a.equals(b))+" >> this compares the content of the literal string");
		System.out.println("a.equals(c) ? "+(a.equals(c))+" >> this compares the content of the literal string");
		System.out.println("a.equals(d) ? "+(a.equals(d))+" >> this compares the content of the literal string");
		System.out.println("=========================");
		System.out.println("a==\"Bonjour\" is "+(a=="Bonjour"));
		System.out.println("b==\"Bonjour\" is "+(b=="Bonjour"));
		System.out.println("c==\"Bonjour\" is "+(c=="Bonjour"));
		System.out.println("d==\"Bonjour\" is "+(d=="Bonjour"));
		
		System.out.println("Bonjour".compareTo(d)); //0 means same content. 
	}

}
