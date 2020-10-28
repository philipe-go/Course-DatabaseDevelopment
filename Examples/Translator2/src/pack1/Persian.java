package pack1;

public class Persian implements Translator{
	private Translator bt; 
	private String competence; 
	
	public Persian (Translator bt){
		this.bt=bt; 
		this.competence="persian";
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