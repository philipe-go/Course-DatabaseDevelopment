package c.liskov_solution2;

public interface IRectangleSquare {

	public abstract double[]  getHoriVert();
	
	public default double perimeter() {
		
		return 2*this.getHoriVert()[0]+ 2*this.getHoriVert()[1];
	}

	public default double area() {
		return this.getHoriVert()[0]*this.getHoriVert()[1];
	}
	
	
}
