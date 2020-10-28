package pack1;

public class Main {

	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle(3,4);
		System.out.println(r1.getSh());
		System.out.println(r1.getSv());
		System.out.println(r1.stringOfSides());
		
		IPolygon r2 = new Rectangle(6,9);
		System.out.println( ((Rectangle)r2).getSh() );
		System.out.println( ((Rectangle)r2).getSv());
		
		System.out.println("Perimetre de r1: "+r1.perimeter());
		System.out.println("Perimetre de r2: "+r2.perimeter());
		
		ColorPolygon cp = new ColorPolygon(r1);
		System.out.println(cp.getColor());
		cp.setColor(Colors.RED);
		System.out.println(cp.getColor());
		System.out.println(cp.stringOfSides());
		
		r1.setSides(30, 40);
		System.out.println(cp.stringOfSides());
		
	}

}
