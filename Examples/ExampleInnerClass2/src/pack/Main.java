package pack;


public class Main {

	public static void main(String[] args) {
		// new -- internal dynamic classes 
		Outter.InnerDy IC = (new Outter()).new InnerDy(10);
		System.out.println(IC.getData());
		
		Outter.InnerDy ICa = (new Outter(5)).new InnerDy(10);
		System.out.println(ICa.getData());
		
		// new -- internal static classes 
		Outter.InnerSt IC2 = new Outter.InnerSt(20);
		System.out.println(IC2.getData());
		
		Outter v= new Outter();
		System.out.println(v.testAccessDy());
		System.out.println(v.testAccessSt());
		System.out.println(Outter.testAccessSt());

	}

}
