package pack;

public class Outter {
	
	public int a= 1; 
	static public int b=2; 
	
	static public int  getOb() {
		return b;
	}
	
	public class A{
		public int getAa() {
			return a;
		}
		public int getAb() {
			return b;
		}
	}
	
	static public class B{
//		public int getBa() {
//			return a;
//		}
		public int getBb() {
			return b;
		}
	}
	

}
