package pack2;

import pack1.A;

public class Program {
	public static void main(String[] args)
	{
		A aa = new A(); //create an instance of the class 
		System.out.println("main in Program.java class inside different package");
		System.out.println("aa.p1 = "+aa.p1pub);
		//System.out.println("aa.p2 = "+aa.p2prot); --> PROGRAM IS NOT DESCENDENT FOR PROTECTED
		//System.out.println("aa.p3 = "+aa.p3non); --> PROGRAM IS NOT DESCENDENT FOR DEFAULT
		//System.out.println("aa.p4 = "+aa.p4priv); --> IT IS PRIVATE
		
		B bb = new B();
		System.out.println("bb.p1 = "+bb.p1pub);
		//System.out.println("bb.p2 = "+bb.p2prot); --> CAN BE USED INSIDE B BUT NOT IN THE PROGRAM - PROTECTED
		System.out.println("bb.p2 = "+bb.b2pub); //B implemented an getter to p2prot
		//System.out.println("bb.p3 = "+bb.p3non); --> CAN BE USED INSIDE B BUT NOT IN THE PROGRAM - DEFAULT
	}
}
