package pack;

import java.util.Arrays;

public class Arrays1 {

	public static void main (String[] args)
	{
		int [] a = {1,2,3};
		int [] b = {5,6};
		b=a;
		System.out.println(b.length);
		for (int u : b)
		{
			System.out.println(u);
		}
	
		a[0] = 100;
			
		for (int u : b) { System.out.println(u); }
		
		int [][] tt = {{1,2,3},{4,5,6}};
		System.out.println("tt = "+Arrays.deepToString(tt));
		for (int[] u : tt) { for (int i = 0;i<u.length;i++) { u[i]=0;} }
		System.out.println("tt = "+Arrays.deepToString(tt));
	}
}
