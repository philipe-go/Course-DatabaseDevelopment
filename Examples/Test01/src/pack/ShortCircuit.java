package pack;

public class ShortCircuit {

	public static void main(String[] args) {
		
		int x=0;
		
		
		if ((x!=0)&&(10/x >= 1)) {
			System.out.println("OK");
		}
		else {
			System.out.println("Not OK");
		}

	}

}
