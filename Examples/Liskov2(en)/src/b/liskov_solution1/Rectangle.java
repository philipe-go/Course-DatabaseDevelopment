package b.liskov_solution1;

public class Rectangle {
	
	// Now Rectangle is a class of immutable objects
	
    protected double hs;
    protected double vs;
    
	public Rectangle() {
		this.hs=0;
		this.vs=0;
	}

	public Rectangle(double hs, double vs) {
		if(hs<0) {this.hs = 0;}
		else {this.hs = hs;}
		if(vs<0) {this.vs = 0;}
		else {this.vs = vs;}
	}

	public double getHs() {
		return hs;
	}

	public double getVs() {
		return vs;
	}
      
	public double perimeter() {
		return 2*hs+2*vs; 
	}
	
	public double area() {
		return hs*vs; 
	}
      
}
