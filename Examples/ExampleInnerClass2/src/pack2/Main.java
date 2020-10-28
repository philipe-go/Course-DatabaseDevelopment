package pack2;

public class Main {

	public static void main(String[] args) {
		
		Circle.Point p1= new Circle.Point(1,1);
		Circle c1 = new Circle(p1, 4);
		System.out.println(c1);
		Circle.Center center1 = c1.new Center();
		System.out.println(center1);
		
		Circle c2 = new Circle (center1, 10);
		System.out.println(c2);
		
	}

}
