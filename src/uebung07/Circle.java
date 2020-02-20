package uebung07;

public class Circle extends Ellipse implements MoveAndPaintable {

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
			return this.corner.equals(go.corner) && this.width == go.width
					&& this.height == go.height;
		}
		return false;
	}	

	@Override
	public String toString() {
		return "Circle: " + corner + " | " + moving + " d: " + width;
	}
}
