package pack;

import java.util.Arrays;

public class Program {

	public static void main(String[] args) {

		int c [][] = {{1,2, 3} , {1, 2, 3, 4}};
		System.out.println("length of c = "+ c.length);
		System.out.println("length of c[0] = "+ c[0].length);
		System.out.println("length of c[1] = " + c[1].length);
		
		int d [][] = new int[2][];
		d[0] = new int [] {1,2, 3};
		d[1]= new int [] {1,2, 3, 4};
		System.out.println("length of d = "+ d.length);
		System.out.println("length of d[0] = "+ d[0].length);
		System.out.println("length of d[1] = " + d[1].length);
		
		System.out.println("Here is c: "+Arrays.deepToString(c));
		System.out.println("Here is d: "+Arrays.deepToString(d));

	}

}
