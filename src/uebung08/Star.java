package uebung08;

import java.awt.Graphics;
import java.awt.Polygon;

public class Star extends GeometricObject{

	int innerradius, outerradius, anz;

	public Star(Vertex c, int or, int ir, int anz) {
		this(c, new Vertex(0, 0), or, ir, anz);
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
	public void paintMeTo(Graphics g) {
		Vertex middle = new Vertex(corner.x + (width / 2), corner.y
				+ (height / 2));
		Polygon s = new Polygon();
		double x[] = new double[2 * anz];
		double y[] = new double[2 * anz];
		
		for (int i = 0; i < 2 * anz; i++) {
			x[i] = (Math.round(Math.cos(Math.PI / anz * i - Math.PI / 2) * outerradius) + middle.x);
			y[i] = (Math.round(Math.sin(Math.PI / anz * i - Math.PI / 2) * outerradius) + middle.y);
			i++;
			x[i] = (Math.round(Math.cos(Math.PI / anz * i - Math.PI / 2) * innerradius) + middle.x);
			y[i] = (Math.round(Math.sin(Math.PI / anz * i - Math.PI / 2) * innerradius) + middle.y);
		}
		for (int i = 0; i < 2 * anz; i++) {
			s.addPoint((int) x[i], (int) y[i]);
		}
		g.fillPolygon(s);

	}
}
