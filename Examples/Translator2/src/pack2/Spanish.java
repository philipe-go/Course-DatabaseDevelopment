package pack2;

public class Spanish extends LanguageTranslator{
	
	private Language competence; 
	
	public Spanish (Translator bt){
		super(bt);  // this.bt=bt;	
		this.competence=Language.spanish;
	}
	
	@Override
	public String getCompetence(){
		return this.competence+ ", "+bt.getCompetence();
	}	
	@Override
	public String detailCompetence(Language l){
		if (l==Language.spanish){
			return "Specific details of "+ l +".";
		}
		else {
			return bt.detailCompetence(l);
		}
			
	}
}
