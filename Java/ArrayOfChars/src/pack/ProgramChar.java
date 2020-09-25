package pack;

import java.util.Arrays;

public class ProgramChar {
	public static void main(String[] args)
	{
		char[] tt = {'a','b','c'};
		System.out.println("tt = "+tt+" << Memory location on stack");
		
		System.out.println("tt = "+tt.toString()+" << Memory location on stack");
		
		System.out.println("tt with Arrays = "+Arrays.toString(tt)+" << Object on the Heap");
	}
}
