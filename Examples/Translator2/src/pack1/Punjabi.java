package pack1;

public class Punjabi implements Translator{
	private Translator bt; 
	private String competence; 
	
	public Punjabi (Translator bt){
		this.bt=bt; 
		this.competence="punjabi";
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
