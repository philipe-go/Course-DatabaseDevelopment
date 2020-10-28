package pack;

public class Shifts {

	public static void main(String[] args) {
		
		byte a = 44; 
		a<<=3;
		System.out.println(a); 
		
		a=-65;
		a= (byte) (a>>2) ;
		System.out.println(a); 
		
		a=-65;
		a=(byte) (a>>>2);  // problem in the conversion to integer and back to byte
		System.out.println(a); 
		
		int b = -1; 
		b=b>>30;
		System.out.println(b);
		
		b = -1; 
		b=b>>>30;
		System.out.println(b);
		
		
	}

}
