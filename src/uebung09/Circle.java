package uebung09;

public class Circle extends Ellipse{

	public Circle(double r){
		this(new Vertex(0,0), new Vertex(0, 0), r);
	}

	public Circle(double r, Vertex m) {
		this(new Vertex(0,0),m, r);
	}	
	
	public Circle(Vertex c, Vertex m, double r) {
		super(c, m, r*2, r*2);
	}
	
	@Override
	public boolean equals(Object o){
		if(o.getClass().equals(this.getClass())){
			Circle go = (Circle)o;
			return super.equals(go);
		}
		return false;
	}	

	@Override
	public String toString() {
		return "Circle: "+super.toString();
	}
}
