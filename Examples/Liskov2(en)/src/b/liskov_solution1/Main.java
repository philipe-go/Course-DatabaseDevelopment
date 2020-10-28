package b.liskov_solution1;

import a.liskov_violation.Rectangle;
import a.liskov_violation.Square;

public class Main {

	public static void test (Rectangle r) {
		
		// The code should work for all the rectangles, but it does not work for squares,
		//  although the square was defined as a type of rectangle.
		
		// The Liskov Substitution principle says that any code that works for objects of a class A must 
		// work also (without change) for the objects of any class B derived from A
		
		// Now, we can not change the side of an object rectangle after it is created
		
//		double intArea =r.area();
//		r.setHs(2*r.getHs());
//		if (r.area()==2* intArea) {
//			System.out.println("OK");
//		}
//		else {
//			int i =1 /0;
//		}
		
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
		System.out.println("Horizontal side of s is "+s.getHs());
		System.out.println("Vertical side of s is "+s.getVs());
		System.out.println("Perimeter of s is "+s.perimeter());
		System.out.println("Area of s is "+s.area());
		System.out.println();
		
		System.out.println("It is no longer possible to duplicate the side of a rectangle or square");
		
			
	}
	
	

}
