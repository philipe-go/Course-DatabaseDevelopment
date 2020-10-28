package d.liskov_solution3;

public class Square extends AbsRectangleSquare {
	
	private double s;

	public Square() {
		s=0;
	}
	
	public Square(double s) {		
		setS(s);
	}

	public double getS() {
		return s;
	}

	public void setS(double s) {
		if(s<0) {this.s = 0;}
		else {this.s = s;}
	}

	@Override
	public double[] getHoriVert() {		
		return new double[] {s,s};
	}
	
}
