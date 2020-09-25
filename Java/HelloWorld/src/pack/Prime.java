package pack;
import java.util.Scanner;

public class Prime {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int prime = sc.nextInt();
		Boolean isPrime = true;
		for (int i=2; i<prime;i++)
		{
			if (prime%i==0) { isPrime = false; break; }
		}
		
		System.out.println("is prime: "+isPrime);
	}
	
}
