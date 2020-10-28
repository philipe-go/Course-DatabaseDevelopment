package pack2;

public abstract class LanguageTranslator implements Translator {
	
	protected Translator bt; 
	
	protected LanguageTranslator(Translator bt){
		this.bt=bt;
	}
	
	@Override
	public String getName(){
		return bt.getName(); 
	}
	@Override
	public String otherInfo1(){
		return bt.otherInfo1();
	}
	@Override
	public String otherInfo2(){
		return bt.otherInfo2();
	}
	@Override
	public String otherInfo3(){
		return bt.otherInfo3();
	}
	@Override
	public abstract String getCompetence();
	@Override
	public abstract String detailCompetence(Language l);

}
