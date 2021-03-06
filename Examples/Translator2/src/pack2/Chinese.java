package pack2;

public class Chinese extends LanguageTranslator{
	private Language competence; 
	
	public Chinese (Translator bt){
		super(bt);  // this.bt=bt;	
		this.competence=Language.chinese;
	}
	
	@Override
	public String getCompetence(){
		return this.competence+ ", "+bt.getCompetence();
	}	
	@Override
	public String detailCompetence(Language l){
		if (l==Language.chinese){
			return "Specific details of "+ l +".";
		}
		else {
			return bt.detailCompetence(l);
		}
			
	}

}