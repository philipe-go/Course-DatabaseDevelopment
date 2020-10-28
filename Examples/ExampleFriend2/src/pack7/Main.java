package pack7;

public class Main {

	public static void main(String[] args) {
		
		Romeo r=Romeo.callROMEO();
		Juliette j =Juliette.callJULIETTE();
		AnotherGuy m= new AnotherGuy("Pierre");
		
		System.out.println("Romeo speaks and Juliette answers");
		r.declareLove(j);
		System.out.println();
		
		System.out.println("Another guy speaks and Juliette answers");
		m.declareLove(j);
		
	}

}
