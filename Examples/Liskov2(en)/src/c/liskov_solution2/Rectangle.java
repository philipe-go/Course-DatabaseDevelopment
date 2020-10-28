package c.liskov_solution2;

public class Rectangle implements IRectangleSquare {
	
    protected double hs;
    protected double vs;
    
	public Rectangle() {
		this.hs=0;
		this.vs=0;
	}

	public Rectangle(double hs, double vs) {
		setHs(hs);
		setVs(vs);
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
      
	
	@Override
	public double[] getHoriVert() {		
		return new double[] {hs,vs};
	}

      
}
