package pack3;

public class BasicTranslator implements Translator{
	
	private String name ; 
	
	BasicTranslator(String name){
		this.name= name;
	}
	
	@Override
	public String getName(){
		return name; 
	}
	@Override
	public String otherInfo1(){
		return "Here is other Info 1";
	}
	@Override
	public String otherInfo2(){
		return "Here is other Info 2";
	}
	@Override
	public String otherInfo3(){
		return "Here is other Info 3";
	}
	@Override
	public String getCompetence(){
		return "";
	}
	@Override
	public String detailCompetence(Language l){
		return "I, "+name+", don't know this language.";
	}
}
