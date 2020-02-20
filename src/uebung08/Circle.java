package uebung08;

public class Circle extends Ellipse{

	public Circle(Vertex c, double d) {
		this(c, new Vertex(0, 0), d);
	}

	public Circle(Vertex c, Vertex m, double d) {
		super(c, m, d, d);
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
		return "Circle: " + corner + " | " + moving + " d: " + width;
	}
}
