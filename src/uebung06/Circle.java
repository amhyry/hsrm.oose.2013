package uebung06;

public class Circle extends Ellipse {

	
	public Circle(Vertex v, double d) {
		this(v,new Vertex(0,0),d);
	}
	
	public Circle(Vertex v, Vertex m, double d) {	
		super(v, m, d, d);
	}	
		
	public String toString(){ return corner + " | " + moving + " d: " + width; }
	
	
	public static void main(String[] args) {	 
		//erstellen der objects Circle mit Circle kreis = new Circle(übergabewerte1,2,3,4);
		//testen der methoden von Circle, bsp kreis.toString();
	}

}
