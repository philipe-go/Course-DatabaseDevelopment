package a.console;


import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestConsole1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
	
	// Solution 1 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		String name1 = sc.nextLine();
		System.out.println("Welcome "+name1);
	//	sc.close();    // It can not be closed now, because it closes the stream System.in
	
	// Solution 2 - requires "throws IOException"			
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your name");
		String name2=br.readLine();
		System.out.println("Welcome "+name2);
		
		sc.close();

	}

}
