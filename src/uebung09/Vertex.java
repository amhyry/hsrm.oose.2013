package uebung09;

class Vertex {
	double x, y;

	Vertex(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
			return "(" + x + "|" + y + ")";

	}

	public void move(Vertex v) {
		this.x = this.x + v.x;
		this.y = this.y + v.y;
	}

	public void moveTo(Vertex v) {
		this.x = v.x;
		this.y = v.y;
	}

	@Override
	public boolean equals(Object o){
		if(o.getClass().equals(this.getClass())){
			Vertex v = (Vertex)o;
			return this.x == v.x && this.y == v.y;
		}
		return false;	
	}
}// end of class

