package a.liskov_violation;

public class Rectangle {
	
    protected double hs;
    protected double vs;
    
	public Rectangle() {
		this.hs=0;
		this.vs=0;
	}

	public Rectangle(double ch, double cv) {
		setHs(ch);
		setVs(cv);
	}

	public double getHs() {
		return hs;
	}

	public void setHs(double hs) {
		if(hs<0) {this.hs = 0;}
		else {this.hs = hs;}
	}

	public double getVs() {
		return vs;
	}

	public void setVs(double vs) {
		if(vs<0) {this.vs = 0;}
		else {this.vs = vs;}
	}
      
	public double perimeter() {
		return 2*hs+2*vs; 
	}
	
	public double area() {
		return hs*vs; 
	}
      
}
