package a.liskov_violation;

public class Square extends Rectangle{
	
	public Square(double s) {
		super(s,s);
	}
	
	@Override
	public void setHs(double hs) {
		super.setHs(hs);
		this.vs=this.hs;
	}
	
	@Override
	public void setVs(double vs) {
		super.setVs(vs);
		this.hs=this.vs;
	}
}
