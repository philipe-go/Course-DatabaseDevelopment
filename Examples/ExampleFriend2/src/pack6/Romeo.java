package pack6;

public class Romeo {
	
	public static class Love {
		private Love() {
		}
	}
	
	private String name;
		
	private Romeo() {
		name="Romeo";
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
