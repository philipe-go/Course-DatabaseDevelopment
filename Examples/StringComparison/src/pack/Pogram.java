package pack;

public class Pogram {

	public static void main(String[] args) {
		
		String a = "Bonjour";
		String b = "Bonjour";
		String c;
		c=a;
		String d = new String("Bonjour");
		System.out.println("a==b is "+(a==b));
		System.out.println("a==c is "+(a==c));
		System.out.println("a==d is "+(a==d));
		System.out.println("a.equals(b) is "+ (a.equals(b)) );
		System.out.println("a.equals(c) is "+ (a.equals(c)) );
		System.out.println("a.equals(d) is "+ (a.equals(d)) );
		System.out.println(" ==================== ");
		System.out.println("a==\"Bonjour\" is "+(a=="Bonjour"));
		System.out.println("b==\"Bonjour\" is "+(b=="Bonjour"));
		System.out.println("c==\"Bonjour\" is "+(c=="Bonjour"));
		System.out.println("d==\"Bonjour\" is "+(d=="Bonjour"));
		System.out.println("Bonjour".compareTo(d));   // 0 means same content.
			
	}

}
