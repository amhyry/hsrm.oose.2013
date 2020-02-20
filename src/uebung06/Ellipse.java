package uebung06;

public class Ellipse extends GeometricObject {

	public Ellipse(Vertex v, double h,double w) {	
		this(v,new Vertex(0,0), h, w);			
	}
	
	public Ellipse(Vertex v, Vertex m, double h,double w) {	
		super(v, m, h, w);
	}	

	public double size(){ return 3.14159265359*(width/2)*(height/2); }
	
	public String toString(){ return corner + " | " + moving + " w: " + width + " h: " + height; }

	public static void main(String[] args) {	
		//erstellen einer ellipse
		//funktionsaufruf einer ellipse
	}
}
