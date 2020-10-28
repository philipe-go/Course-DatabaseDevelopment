package pack7;


public class AnotherGuy {
	
	public static class Love {		
		private Love() {
		}
	}
	
	private String name;

	public AnotherGuy(String nom) {
		this.name = nom;
	}

	public String getNom() {
		return name;
	} 
	
	public void declareLove(Juliette Ju){
		System.out.println("I love you, Juliette");
		Ju.declareLove(new Love());
		
	}
}
