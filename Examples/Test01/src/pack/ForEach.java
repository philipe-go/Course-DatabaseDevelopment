package pack;

import java.util.Arrays;

public class ForEach {

	public static void main(String[] args) {
		
		int [] t ={2, 4, 8, 16,32 };
		for( int u : t) { System.out.print(u + " "); } 
		System.out.println();
		
		System.out.println("And now: ");
		for( int u : t) { u=0; }
		for( int u : t) { System.out.print(u + " "); }
		System.out.println();
		
		System.out.println("Attention to nested arrays:");
		int [][] tt = {{1, 2, 3},{4, 5, 6, 7}};
		System.out.println("tt = "+ Arrays.deepToString(tt));
		for (int[]u : tt) {
			for(int i=0; i<u.length; i++) {u[i]=0;}
		}
		System.out.println("tt = "+ Arrays.deepToString(tt));

	}

}
