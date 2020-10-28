package pack1;

import java.util.*;

public interface IPolygon {
	
		public abstract List<Double> listSides();
	 
		public default String stringOfSides(){
			return(Arrays.toString(this.listSides().toArray()));
		}
		
		public default double perimeter() {
			double p=0; 
			ListIterator<Double> sides = listSides().listIterator();
			while(sides.hasNext()) {
				p=p+sides.next();
			}
			return p;
		};
		
		public abstract double area();
		

}
