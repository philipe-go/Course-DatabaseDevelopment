package pack2;

public class Circle {
	
	private Point c;
	private double r; 
	
	public class Center extends Point{  // center is a point. But center only makes sense 
		                                // for each instance of the class Circle. 
		                                // So the inner class center is DYNAMIC
		private double x; 
		private double y; 
		
		public Center() {
			this.x=c.x;
			this.y=c.y; 
		}

		@Override
		public String toString() {
			return "Center [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static public class Point{   // points do not depend on any instance of the class Circle.
		                         // So the class Point is a static inner class. 
		private double x; 
		private double y; 
		
		protected Point() {}
		
		public Point(double x, double y ) {
			this.x=x;
			this.y=y; 
		}
		
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
	
	
//	public Circle(double x, double y, double r) {
//		this.c=new Point(x,y);
//		this.r=r;
//	}
		
	public Circle(Point c, double r) {
		this.c=c;
		this.r=r;
	}

	@Override
	public String toString() {
		return "Circle [c=" + c + ", r=" + r + "]";
	}
	
	
}
