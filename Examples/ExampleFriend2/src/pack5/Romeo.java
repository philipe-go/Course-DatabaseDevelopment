package pack5;

public class Romeo {
	
	public static class Love {
		private Love() {
		}
	}
	
	private String name;
	private Juliette  Ju=Juliette.callJULIETTE();
	
	private Romeo() {
		name="Romeo";
	}
	private static Romeo r= new Romeo();
	public static Romeo callROMEO() {
		return r;
	}
	
	public void declareLove(){
		System.out.println("I love you, Juliette");
		Ju.declareLove(new Love());
		
	}
	
	

}
