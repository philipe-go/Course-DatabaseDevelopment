package pack1;

public class Portuguese implements Translator{
	private Translator bt; 
	private String competence; 
	
	public Portuguese (Translator bt){
		this.bt=bt; 
		this.competence="portuguese";
	}
	
	@Override
	public String getName(){
		return bt.getName(); 
	}
	
	@Override
	public String getCompetence(){
		return this.competence+ ", "+bt.getCompetence();
	}		

}
