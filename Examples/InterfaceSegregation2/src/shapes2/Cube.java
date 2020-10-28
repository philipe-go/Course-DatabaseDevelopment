package shapes2;

import java.util.ArrayList;
import java.util.List;

public class Cube implements I3DShape{
	int e ;
	 
	
	public Cube(){
		this.e =0;
	}
	
	public Cube(int s){
		if (s>=0){this.e = s;}
		else {this.e = 0;}
		
	}
	
	public void setEdge(int s  ){
		if (s>=0){this.e = s;}
		else {this.e = 0;}
	}
	
	public int getSide(){
		return e;
	}

	
//	public int perimeter(){
//		return -1;
//	}
	public double area(){
		return 6*e*e;
	}
	public double volume(){
		return e*e*e;
	}
	
	public List<Integer> listEdges(){
		List<Integer> l = new ArrayList<Integer>();
		l.add(this.e);
		return l;
	}
	
}

