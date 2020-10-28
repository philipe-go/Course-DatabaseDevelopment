package pack2;

public class Persian extends LanguageTranslator{
	private Language competence; 
	
	public Persian (Translator bt){
		super(bt);  // this.bt=bt;	
		this.competence=Language.persian;
	}
	@Override
	public String getCompetence(){
		return this.competence+ ", "+bt.getCompetence();
	}	
	@Override
	public String detailCompetence(Language l){
		if (l==Language.persian){
			return "Specific details of "+ l +".";
		}
		else {
			return bt.detailCompetence(l);
		}
			
	}
	

}