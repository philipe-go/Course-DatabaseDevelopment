package pack2;

public class Portuguese extends LanguageTranslator{
	private Language competence; 
	
	public Portuguese (Translator bt){
		super(bt);  // this.bt=bt;	
		this.competence=Language.portuguese;
	}
	
	@Override
	public String getCompetence(){
		return this.competence+ ", "+bt.getCompetence();
	}
	@Override
	public String detailCompetence(Language l){
		if (l==Language.portuguese){
			return "Specific details of "+ l +".";
		}
		else {
			return bt.detailCompetence(l);
		}
			
	}

}
