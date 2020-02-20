package uebung08;

import java.awt.Graphics;

public class Ellipse extends GeometricObject{

	public Ellipse(Vertex c, double h, double w) {
		this(c, new Vertex(0, 0), h, w);
	}

	public Ellipse(Vertex c, Vertex m, double h, double w) {
		super(c, m, h, w);
	}

	@Override
	public double size() {
		return 3.14159265359 * (width / 2) * (height / 2);
	}
	
	@Override
	public boolean equals(Object o){
		if(o.getClass().equals(this.getClass())){
			Ellipse go = (Ellipse)o;
			return super.equals(go);
		}
		return false;
	}	

	@Override
	public String toString() {
		return "Ellipse: " + corner + " | " + moving + " w: " + width + " h: " + height;
	}
	
	@Override
	public void paintMeTo(Graphics g) {
		g.drawOval((int)this.corner.x, (int)this.corner.y, (int)width, (int)height);
	}	
}
