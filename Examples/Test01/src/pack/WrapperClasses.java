package pack;

public class WrapperClasses {

	public static void main(String[] args) {
		
		boolean a = true;
		Boolean b = true;
		if (a==b) {
			System.out.println("a==b");
		}
		
		byte c = 20; 
		Byte d = 20; 
		if (c==d) {
			System.out.println("c==d");
		}
		
		short e = 50;
		Short f = 50; 
		if (e==f) {
			System.out.println("e==f");
		}
		
	    int g = 100;
	    Integer h = 100;
	    if (g==h) {
			System.out.println("g==h");
		}
	    
	    long i = 200L;   // It could be just: long i = 200;  since int is implicitly casted to long
	    Long j = 200L;
	    if (i==j) {
			System.out.println("i==j");
		}
	    
	    float k = 1.5f;
	    Float l = 1.5f;
	    if (k==l) {
			System.out.println("k==l");
		}
	    
	    double m = 2.55;
	    Double n = 2.55;
	    if (m==n) {
			System.out.println("m==n");
		}
		

	}

}
