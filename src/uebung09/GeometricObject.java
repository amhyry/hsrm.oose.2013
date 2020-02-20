package uebung09;

import java.awt.Graphics;

class GeometricObject implements MoveAndPaintable {
	Vertex corner, moving;
	double width, height;

	public GeometricObject(double h, double w) {
		this(new Vertex(0,0), new Vertex(0, 0), h, w);
	}// end of go
	
	public GeometricObject(Vertex c, double h, double w) {
		this(c, new Vertex(0, 0), h, w);
	}// end of go

	public GeometricObject(Vertex c, Vertex m, double h, double w) {
		super();
		if (width<0) {
			corner.x = corner.x+width;
			width = -width;
		}
		if (height<0) {
			corner.y = corner.y+height;
			height = -height;
		}		
		
		this.corner = c;
		this.moving = m;
		this.width = w;
		this.height = h;
	}// end of go

	public double size() {
		return width * height;
	}

	public boolean isLargerThan(GeometricObject that) {
		return this.size() > that.size();
	}

	public boolean isAbove(GeometricObject that) {
		return this.corner.y + this.height < that.corner.y;
	}

	public boolean isUnderneath(GeometricObject that) {
		return this.corner.y > that.corner.y + that.height;
	}

	public boolean isLeftOf(GeometricObject that) {
		return this.corner.x + this.width < that.corner.x;
	}

	public boolean isRightOf(GeometricObject that) {
		return this.corner.x > that.corner.x + that.width;
	}

	public boolean touches(GeometricObject that) {
		return !(this.isAbove(that) || this.isUnderneath(that)
				|| this.isLeftOf(that) || this.isRightOf(that));
	}
		
	@Override
	public boolean equals(Object o){
		if(o.getClass().equals(this.getClass())){
			GeometricObject go = (GeometricObject)o;
			return this.corner.equals(go.corner) && this.width == go.width
					&& this.height == go.height;
		}
		return false;
	}

	public void move() {
		this.corner.move(moving);
	}

	public String toString() {
		return corner + " | " + moving + " w:" + width + " h:" + height;
	}

	@Override
	public void paintMeTo(Graphics g) {
		//g.create();
		//g.drawRect((int)this.corner.x, (int)this.corner.y, (int)width, (int)height);
		g.fillRect((int)this.corner.x, (int)this.corner.y, (int)width, (int)height);
	}

}// end of class