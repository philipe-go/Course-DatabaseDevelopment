package pack7;

public class Romeo {
	
	public static class Love {
		private Love() {
		}
	}
	
	private String nom;	
	private Romeo() {
		nom="Romeo";
	}
	private static Romeo r= new Romeo();
	public static Romeo callROMEO() {
		return r;
	}
	
	public void declareLove(Juliette Ju){
		System.out.println("I love you, Juliette");
		Ju.declareLove(new Love());
		
	}
	
	

}
