package singleton;

public class Singleton {
	private int data ;
	
	private Singleton() {
		this.data=0;
	}
	
	private static Singleton Mary= new Singleton();
	
	public static Singleton getINSTANCE() {
		return Mary;
	}
	
	public int getData() {
		return this.data;
	}
	public void setData(int data) {
		this.data=data;
	}

}
