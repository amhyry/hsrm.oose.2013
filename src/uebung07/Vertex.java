package uebung07;

class Vertex {
	double x, y;

	Vertex(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		String temp = "(" + x + "|" + y + ")";
		return temp;
	}

	public void move(Vertex v) {
		x = x + v.x;
		y = y + v.y;
	}

	public void moveTo(Vertex v) {
		x = v.x;
		y = v.y;
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

