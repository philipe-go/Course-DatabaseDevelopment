package pack1;



public class Main {
	
	static String  myFunction(ImmRectangle r){
		if (r.getClass()==ImmRectangle.class){ 
			return "rectangle";
		}
		else if (r.getClass()==ImmSquare.class){ 
			// int x= 1/0;
			return "square";  
		}
		else return "unknown";
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ImmRectangle r1 = new ImmRectangle(3,5);
		ImmSquare a= new ImmSquare(10) ;
		System.out.println(" r1 is a "+ myFunction(r1));
		System.out.println(" a is a "+ myFunction(a));
		
		System.out.println(a instanceof ImmRectangle ); 

	}

}
