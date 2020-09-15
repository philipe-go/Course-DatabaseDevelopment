package pack1;

public class Program {
	public static void main(String[] args)
	{
		A aa = new A(); //create an instance of the class 
		System.out.println("main in Program.java class inside same package");
		System.out.println("aa.p1 = "+aa.p1pub);
		System.out.println("aa.p2 = "+aa.p2prot);
		System.out.println("aa.p3 = "+aa.p3non);
		//System.out.println("aa.p4 = "+aa.p4priv); --> IT IS PRIVATE
	}

}

