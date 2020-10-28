package pack5;

public class Juliette {
	
	private String name; 
	private Juliette() {
		name="Juliette";
	}
	private static Juliette j= new Juliette();
	public static Juliette callJULIETTE() {
		return j;
	}
	public void talk() {
		System.out.println("Hello");		
	}
	public void declareLove(Romeo.Love a) {
		System.out.println("I love you, Romeo");	
	}

}
