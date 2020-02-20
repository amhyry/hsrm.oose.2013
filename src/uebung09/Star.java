package uebung09;

import java.awt.Graphics;
import java.awt.Polygon;

public class Star extends GeometricObject{

	int innerradius, outerradius, anz;

	public Star(Vertex c, int or, int ir, int anz) {
		this(c, new Vertex(0, 0), or, ir, anz);
	}
	
	public Star(int or, int ir, int anz) {
		this(new Vertex(0, 0), new Vertex(0, 0), or, ir, anz);
	}	

	public Star(Vertex c, Vertex m, int or, int ir, int anz) {
		super(c, m, or + or, or + or);
		this.innerradius = ir;
		this.outerradius = or;
		this.anz = anz;
	}// end of go

	@Override
	public boolean equals(Object o) {
		if (o.getClass().equals(this.getClass())) {
			Star go = (Star) o;
			return this.corner.equals(go.corner) 
					&& this.innerradius == go.innerradius
					&& this.outerradius == go.outerradius && this.anz == go.anz;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Star: " + super.toString();
	}

	public double[][] getCoords(){
		Vertex middle = new Vertex(corner.x + (width / 2), corner.y
				+ (height / 2));
		double xy[][] = new double[2][2*anz];
		for (int i = 0; i < 2 * anz; i++) {
			xy[0][i] = (Math.round(Math.cos(Math.PI / anz * i - Math.PI / 2) * outerradius) + middle.x);
			xy[1][i] = (Math.round(Math.sin(Math.PI / anz * i - Math.PI / 2) * outerradius) + middle.y);
			i++;
			xy[0][i] = (Math.round(Math.cos(Math.PI / anz * i - Math.PI / 2) * innerradius) + middle.x);
			xy[1][i] = (Math.round(Math.sin(Math.PI / anz * i - Math.PI / 2) * innerradius) + middle.y);
		}		
		return xy;
	}
	
	@Override
	public void paintMeTo(Graphics g) {
		Polygon s = new Polygon();
		double xy[][] = this.getCoords();
		for (int i = 0; i < 2 * anz; i++) {
			s.addPoint((int) xy[0][i], (int) xy[1][i]);
		}
		g.fillPolygon(s);
	}
}
