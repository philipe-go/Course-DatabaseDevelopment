package pack;

public class Arrays1 {

	public static void main(String[] args) {
		
		int [ ] a = { 1, 2, 3} ;
		int [ ] b = { 4, 5} ;
		b=a;
		System.out.println("length of b = "+b.length);
		for (int i=0; i<b.length; ++i){
			System.out.println("b[" + i + "] = " +b[i]);	
		}
		a[0]=100;
		System.out.println("b[0] = "+b[0]);
		
	}

}
