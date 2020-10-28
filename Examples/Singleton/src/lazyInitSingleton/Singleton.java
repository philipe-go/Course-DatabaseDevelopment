package lazyInitSingleton;

public class Singleton {
	private int data ;
	
	private Singleton() {
		this.data=0;
	}
	
	private static Singleton Mary= null;
	
	public static Singleton getINSTANCE() {
		if (Mary==null){ 
			Mary = new Singleton();
		}
		return Mary;
	}
	
	public int getData() {
		return this.data;
	}
	public void setData(int data) {
		this.data=data;
	}

}
