package Pack2;

import java.util.*;

public abstract class AbsPolygon {
	
		public abstract List<Double> listSides();
	 
		@Override
		public final String toString(){
			return(Arrays.toString(this.listSides().toArray()));
		}
		
		public final double perimeter() {
			double p=0; 
			ListIterator<Double> sides = listSides().listIterator();
			while(sides.hasNext()) {
				p=p+sides.next();
			}
			return p;
		};
		
		public abstract double area();
		

}
