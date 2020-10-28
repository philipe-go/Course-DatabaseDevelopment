package pack1;

public class Program {

	public static void main(String[] args) {
		A aa = new A();
		System.out.println("main in the class Program in package pack1");
		System.out.println("aa.p01 = "+ aa.p01);
		System.out.println("aa.p02 = "+ aa.p02);
		System.out.println("aa.p03 = "+ aa.p03);	
		// System.out.println("aa.p04 = "+ aa.p04);  // p04 is private to aa (class A)
	}
	
}
