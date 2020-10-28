package pack1;

public class Spanish implements Translator{
	private Translator bt; 
	private String competence; 
	
	public Spanish (Translator bt){
		this.bt=bt; 
		this.competence="spanish";
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
