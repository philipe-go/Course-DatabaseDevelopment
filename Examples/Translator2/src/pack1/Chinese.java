package pack1;

public class Chinese implements Translator{
	private Translator bt; 
	private String competence; 
	
	public Chinese (Translator bt){
		this.bt=bt; 
		this.competence="chinese";
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