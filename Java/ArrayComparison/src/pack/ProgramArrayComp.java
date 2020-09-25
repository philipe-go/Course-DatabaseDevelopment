package pack;

import java.util.Arrays;

public class ProgramArrayComp {
	public static void main(String[] args)
	{
		int[] a = {1,2,3,4,5};
		int[] b = {1,2,3,4,5};
		int[] c;
		c=a;
		
		System.out.println("a==b ? "+(a==b)+" >> compares the stack address of a and b");
		System.out.println("a==c ? "+(a==c)+" >> compares the stack address of a and a");
		System.out.println("a.equals(b) ? "+(a.equals(b))+" >> compares the stack address of a and b");
		System.out.println("a.equals(c) ? "+(a.equals(c))+" >> compares the stack address of a and a");
		System.out.println("Arrays.equaLs(a,b) ? "+(Arrays.equals(a,b))+" >> compares the heap content of a and b");
		System.out.println("Arrays.equaLs(a,c) ? "+(Arrays.equals(a,c))+" >> compares the heap content of a and c");
	}
}
