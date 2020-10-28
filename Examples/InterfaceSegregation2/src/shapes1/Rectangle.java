package shapes1;

import java.util.*;

public class Rectangle implements IShape {
	int sh ;
	int sv; 
	
	public Rectangle(){
		this.sh = this.sv =0;
	}
	
	public Rectangle(int sh , int sv){
		setSides(sh, sv);
	}
	
	public void setSides(int sh , int sv){
		if (sh>=0){this.sh = sh;}
		else {this.sh = 0;}
		if (sv>=0){this.sv = sv;}
		else {this.sv = 0;}		
	}
	
	public int getHorizontalSide(){
		return sh;
	}
	public int getVerticalSide(){
		return sv;
	}
	public int perimeter(){
		return 2*sh+2*sv;
	}
	public double area(){
		return sh*sv;
	}
	
	public double volume(){
		return 0;
	}
	
	public List<Integer> listSides(){
		List<Integer> l = new ArrayList<Integer>();
		l.add(this.sh);
		l.add(this.sv);
		return l;
	}
}
