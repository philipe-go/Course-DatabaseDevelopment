package pack2;

import pack1.A;

public class Program {

	public static void main(String[] args) {
		A aa = new A();
		System.out.println("main in the class Program in package pack2");
		System.out.println("aa.p01 = "+ aa.p01);
		// System.out.println("aa.p02 = "+ aa.p02);  // p02 is only visible inside the same pack as class A OR 
		                                             //     in classes derived from A (extends A)
		// System.out.println("aa.p03 = "+ aa.p03);	 // p03 is only visible inside the same pack as class A
		// System.out.println("aa.p04 = "+ aa.p04);	 // p04 is private to aa (class A)
		
		B bb= new B();
		System.out.println("bb.p01 = "+ bb.p01);
		// System.out.println("bb.p02 = "+ bb.p02); // p02 is visible inside class B (it extends A) but not here
		// System.out.println("bb.p03 = "+ bb.p03); // p03 is only visible inside the same pack as class A
		System.out.println("bb.p02B = "+ bb.p02B);  // p02B is public and it encapsulate p02
		
	}

}
