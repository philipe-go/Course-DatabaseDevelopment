package Pack2;

import java.util.*;

public class ColorPolygon extends AbsPolygon {
	
	AbsPolygon  p ;
	Colors c;
	
	public ColorPolygon(AbsPolygon p) {
		this.p=p;
		c=Colors.DEFAULT;
	}
	
	public ColorPolygon(AbsPolygon p, Colors c) {
		this.p=p;
		this.c=c;
	}
	
	public Colors getColor() {
		return this.c;
	}

	public void setColor(Colors c ) {
		this.c=c;
	} 
	@Override
	public double area(){
		return this.p.area();
	}
	
	@Override
	public List<Double> listSides(){
		return this.p.listSides();
	}
	

}
