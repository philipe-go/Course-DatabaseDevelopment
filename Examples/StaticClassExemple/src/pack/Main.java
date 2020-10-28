package pack;

public class Main {

	public static void main(String[] args) {
		
		
		Outter v1= new Outter();   
		System.out.println(v1.b);             // accessing static attribute in a dynamic way 
		System.out.println(v1.getOb());       // accessing static methods in a dynamic way  
		System.out.println(Outter.b);         // accessing static attribute in a static way  
		System.out.println(Outter.getOb());   // accessing static methods in a static way 
		
		System.out.println("==========================");
		
//		Outter.A v2=v1.new A();
		Outter.A v2=new Outter().new A();   
		System.out.println(v2.getAa());    //1
		System.out.println(v2.getAb());    //2
		
		Outter.B v3 = new Outter.B();
		System.out.println(v3.getBb());       //2
			

	}

}
