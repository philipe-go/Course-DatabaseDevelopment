package c.liskov_solution2;

public class Main {

	public static void test (IRectangleSquare r) {
		
		// The code should work for all the rectangles, but it does not work for squares,
		//  although the square was defined as a type of rectangle.
		
		// The Liskov Substitution principle says that any code that works for objects of a class A must 
		// work also (without change) for the objects of any class B derived from A
		
		double initArea =r.area();
//		r.setHs(2*r.getHs());            // there is no way to duplicate the horizontal side in the interface
//		if (r.area()==2* initArea) {
//			System.out.println("OK");
//		}
//		else {
//			int i =1 /0;
//		}
		
	}
	
	public static void test2 (IRectangleSquare r) {
		
		// Bad code. Hard to maintain
		
		if (r.getClass()==Rectangle.class) {
			double initArea =r.area();
//			r.setHs(2*r.getHs());        // there is no way to duplicate the horizontal side in the interface
//			if (r.area()==2* initArea) {
//				System.out.println("OK");
//			}
//			else {
//				int i =1 /0;
//			}
		}
		if (r.getClass()==Square.class) {
			double initArea =r.area();
//			r.setHs(2*r.getHs());        // there is no way to duplicate the horizontal side in the interface
//			if (r.area()==4* initArea) {
//				System.out.println("OK");
//			}
//			else {
//				int i =1 /0;
//			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Rectangle r = new Rectangle(3,5);
		System.out.println("Rectangle");
		System.out.println("Horizontal side of r is "+r.getHs());
		System.out.println("Vertical side of r is "+r.getVs());
		System.out.println("Perimeter of r is "+r.perimeter());
		System.out.println("Area of r is "+r.area());
		System.out.println();
		
		Square s = new Square(7);
		System.out.println("Square");
		System.out.println("Horizontal side of s is "+s.getS());
		System.out.println("Vertical side of s is "+s.getS());
		System.out.println("Perimeter of s is "+s.perimeter());
		System.out.println("Area of s is "+s.area());
		System.out.println();
		
		System.out.println("Now I want to duplicate the horizontal side of the rectangle");
		r.setHs(2*r.getHs());
		System.out.println("Horizontal side of r is "+r.getHs());
		System.out.println("Vertical side of r is "+r.getVs());
		System.out.println();
		
		System.out.println("Now I want to duplicate the horizontal side of the square");
		s.setS(2*s.getS());
		System.out.println("Horizontal side of s is "+s.getS());
		System.out.println("Vertical side of s is "+s.getS());
		System.out.println("The type of s is "+s.getClass());
		System.out.println();
		
		System.out.println("Now, we execute the function test2() for r ");
		test2(r); 
		
		System.out.println("Now, we execute the function test2() for s ");
		test2(s); 
		
		System.out.println("Now, we execute the function test() for r ");
		test(r); 
		
		System.out.println("Now, we execute the function test() for s ");
	    test(s); 
		
	
		
		
	}
	
	

}
