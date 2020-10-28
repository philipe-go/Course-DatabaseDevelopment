package pack1;

import java.util.ArrayList;
import java.util.List;

public class Square implements IPolygon {
	
	double s ;
		
	public Square(){
		this.s =0;
	}
	
	public Square(double s){
		setSides(s);
	}
	
	public void setSides(double s){
		if (s>=0){this.s = s;}
		else {this.s = 0;}
		
	}
	
	public double getS(){
		return s;
	}

    @Override
	public double area(){
		return s*s;
	}
	
    @Override
	public List<Double> listSides(){
		List<Double> l = new ArrayList<Double>();
		l.add(this.s);
		l.add(this.s);
		l.add(this.s);
		l.add(this.s);
		return l;
	}
	
}
