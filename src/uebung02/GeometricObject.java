package uebung02;
class GeometricObject{
	Vertex corner;
	double width, height;
	
	GeometricObject(Vertex c, double w, double h){
		this.corner = c;
		this.width = w;
		this.height = h;
	}//end of go
	
	public String toString(){
		return corner + " w:" + width + " h:" + height;
		
	}//end of toString
	
	public static void main(String args[]){
		Vertex v = new Vertex(3,3);
		GeometricObject go = new GeometricObject(v,10,10);
		System.out.println(go.toString());
	}//end of main
	
	
}//end of class