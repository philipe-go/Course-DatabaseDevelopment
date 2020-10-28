package pack;

import java.util.Arrays;

public class Program {

	private static void f1(int a){
		a=0;
	}
	
	private static void f2(int[] a){
		for(int i=0; i<a.length; ++i){
			a[i]=0;
		}
	}
	
	public static void main(String[] args) {

		int b=10;
		f1(b);                             // call by value
		System.out.println("b = " + b);
		
		int[]c={1, 2, 3};
		f2(c);
		System.out.println("c = " + Arrays.toString(c));
		
	}

}
