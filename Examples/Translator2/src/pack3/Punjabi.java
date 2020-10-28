package pack3;

public class Punjabi extends LanguageTranslator{
	
	private Language competence; 
	
	public Punjabi (Translator bt){
		super(bt);  // this.bt=bt;	 
		this.competence=Language.punjabi;
	}
	
	@Override
	public String getCompetence(){
		return this.competence+ ", "+bt.getCompetence();
	}	
	@Override
	public String detailCompetence(Language l){
		if (l==Language.punjabi){
			return this.bt.getName() + " specific details of "+ l +".";
		}
		else {
			return bt.detailCompetence(l);
		}
			
	}


}
