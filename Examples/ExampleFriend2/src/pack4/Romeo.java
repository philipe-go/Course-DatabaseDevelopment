package pack4;

public class Romeo {
	
	public static class Love {
		private Love() {
		}
	}
	
	private String name;
	private Juliette  Ju=new Juliette();
	public Romeo() {
		name="Romeo";
	}
	
	public void declareLove(){
		System.out.println("I love you, Juliette");
		Ju.declareLove(new Love());
		
	}
	
	

}
