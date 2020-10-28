package pack7;

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
	public void declareLove(Object a) {  
		
		if(a.getClass() == Romeo.Love.class) {	  // a is exactly of the class Romeo.Love
	//	if (a instanceof Romeo.Love) {            // a is of the class Romeo.Love 
		                                          // OR of a class derived from the class Romeo.Love
		System.out.println("I love you, Romeo");	
		}
		else {
			talk();
		}
	}

}
