package pack1;

import java.util.*;

public class Rectangle implements IPolygon {
	private double sh ;
	private double sv; 
	
	public Rectangle(){
		this.sh = this.sv =0;
	}
	
	public Rectangle(double sh , double sv){
		setSides(sh, sv);
	}
	
	public void setSides(double sh , double sv){
		if (sh>=0){this.sh = sh;}
		else {this.sh = 0;}
		if (sv>=0){this.sv = sv;}
		else {this.sv = 0;}		
	}
	
	public double getSh(){
		return sh;
	}
	public double getSv(){
		return sv;
	}
	
	@Override
	public double area(){
		return sh*sv;
	}
	
	@Override
	public List<Double> listSides(){
		List<Double> l = new ArrayList<Double>();
		l.add(this.sh);
		l.add(this.sv);
		l.add(this.sh);
		l.add(this.sv);
		return l;
	}
}
