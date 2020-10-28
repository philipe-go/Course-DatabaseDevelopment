package pack1;

public class BasicTranslator implements Translator{
	
	private String name ; 
	
	BasicTranslator(String name){
		this.name= name;
	}
	
	@Override
	public String getName(){
		return name; 
	}
	@Override
	public String getCompetence(){
		return "";
	}		
}
