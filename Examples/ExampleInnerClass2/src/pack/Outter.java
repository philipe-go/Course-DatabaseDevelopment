package pack;


public class Outter {
	private int k; 
	
	public Outter() {
		k=0; 
	}
	public Outter(int j) {
		k=j; 
	}
	public int getData() {
		return k; 
	}
	
	public class InnerDy{  // dynamic class
		private int i; 
		public InnerDy(int j) {
			i=j+k;
		}
		public int getData() {
			return i; 
		}
	}
	
	public static class InnerSt{ // static class
		private int i; 
		public InnerSt(int j) {
			i=j;
		}
		public int getData() {
			return i; 
		}
	}
	
	public int testAccessDy() {
		// This method must be dynamic because  
	    // InnerDy is dynamic
		InnerDy w = new InnerDy(100);  // = this.new InnerDy(100)
		
		// The external class can access the private attributes 
		// of the objects of the internal dynamic class. 
		return w.i;   
	}
	
	static public int testAccessSt() {
		// This method can be static (or dynamic) since  
		// InnerSt is static
		InnerSt w= new InnerSt(200);
		
		// The external class can access the private attributes 
		// of the objects of the internal static class. 
		return w.i;   
	}


}
