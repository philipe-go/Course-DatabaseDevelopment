package shapes1;

import java.util.ArrayList;
import java.util.List;

public class EquilateralTriangle implements IShape {
	
	private int s;
	
	public EquilateralTriangle(){
			this.s=0;
		}
	
	public EquilateralTriangle(int s){
		setSide(s);
	}
	
	void setSide(int s){
		if (s>=0){this.s=s;}
		else {this.s=0;}
	}
	
	int getSide(){
		return s;
	}
	
	public int perimeter(){
		return 3*s;
	}
	public double area(){
		return s*s*Math.sqrt(3)/4;
	}
	
	public double volume(){
		return 0;
	}
	
	public List<Integer> listSides(){
		List<Integer> l = new ArrayList<Integer>();
		l.add(this.s);
		return l;
	}

}
