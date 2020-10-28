package d.liskov_solution3;

public abstract class AbsRectangleSquare {

	public abstract double[]  getHoriVert();
	
	public final double perimeter() {
		
		return 2*this.getHoriVert()[0]+ 2*this.getHoriVert()[1];
	}

	public final double area() {
		return this.getHoriVert()[0]*this.getHoriVert()[1];
	}
	
	
}
