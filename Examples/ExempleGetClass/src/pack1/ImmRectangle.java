package pack1;

public class ImmRectangle {
	int sh ;
	int sv; 
	
	public ImmRectangle(){
		this.sh = this.sv =0;
	}
	
	public ImmRectangle(int sh , int sv){
		if (sh>=0){this.sh = sh;}
		else {this.sh = 0;}
		if (sv>=0){this.sv = sv;}
		else {this.sv = 0;}
	}
	
//	public void setSides(int sh , int sv){
//		if (sh>=0){this.sh = sh;}
//		else {this.sh = 0;}
//		if (sv>=0){this.sv = sv;}
//		else {this.sv = 0;}		
//	}
	
	public int getHorizontalSide(){
		return sh;
	}
	public int getVerticalSide(){
		return sv;
	}
	public int perimeter(){
		return 2*sh+2*sv;
	}
	public int area(){
		return sh*sv;
	}
	
}
