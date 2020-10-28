package pack3;

public class John {
	
	public class FidoMaster {
		private FidoMaster() {
		}
	}
	
	private String name;
	private Dog F=new Dog();;
	
	public John() {
		name="John";
	}
	
	public void commandFido(){
		System.out.println("I am the owner of Fido");
		F.obey(new FidoMaster());
				
	}
	
	

}
