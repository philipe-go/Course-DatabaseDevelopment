package pack1;

import java.util.ArrayList;
import java.util.List;

public class EquilateralTriangle implements IPolygon {
	
	private double s;
	
	public EquilateralTriangle(){
			this.s=0;
		}
	
	public EquilateralTriangle(double s){
		setS(s);
	}
	
	void setS(double s){
		if (s>=0){this.s=s;}
		else {this.s=0;}
	}
	
	double getS(){
		return s;
	}
	
	@Override
	public double area(){
		return s*s*Math.sqrt(3)/4;
	}
	
	@Override
	public List<Double> listSides(){
		List<Double> l = new ArrayList<Double>();
		l.add(this.s);
		l.add(this.s);
		l.add(this.s);
		return l;
	}

}
