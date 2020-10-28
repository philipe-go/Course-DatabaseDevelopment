package pack;

import java.util.Scanner;

public class Program {
	
	private static boolean isPrime(int n) {
		boolean r = true;
		for(int i=2; r && (i<=Math.sqrt(n)); i++) {
			if (n%i ==0) {
				r=false; 
			}
		}
		return r;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an integer number greater than 1:");
		String line =sc.nextLine();
		try {
			int n = Integer.parseInt(line);
			if(n<=1) {throw new Exception();} 		
			if(isPrime(n)) {
				System.out.println(n+" is prime");
			}
			else {
				System.out.println(n+" is not prime");
			}
		}
		catch(Exception e) {
			System.out.println("Invalid input");
		}

	}

}
