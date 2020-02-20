package uebung05;

class GeometricObject{
	Vertex corner, moving;
	double width, height;
	
	public GeometricObject(Vertex c, double w, double h){
		this(c,new Vertex(0,0),w,h);
	}//end of go
	
	public GeometricObject(Vertex c,Vertex m, double w, double h){
		this.corner = c;
		this.moving = m;
		this.width = w;
		this.height = h;
	}//end of go	
	
	public double size(){ return width*height; }
	
	public boolean isLargerThan(GeometricObject that){ return this.size()>that.size(); }
	
	public boolean isAbove(GeometricObject that){ return this.corner.y+this.height < that.corner.y; }
	public boolean isUnderneath(GeometricObject that){ return this.corner.y>that.corner.y+that.height; }
	public boolean isLeftOf(GeometricObject that){ return this.corner.x+this.width < that.corner.x; }
	public boolean isRightOf(GeometricObject that){ return this.corner.x > that.corner.x+that.width; }
	public boolean touches(GeometricObject that){ return !(this.isAbove(that)||this.isUnderneath(that))||(this.isLeftOf(that)||this.isRightOf(that)); }
	
	public void move(){ this.corner.move(moving); }
	
	public String toString(){ return corner + " | " + moving + " w:" + width + " h:" + height; }
	
	public static void main(String args[]){
		GeometricObject go1 = new GeometricObject(new Vertex(2,2),new Vertex(6,5),1,1);
		GeometricObject go2 = new GeometricObject(new Vertex(4,4),new Vertex(3,3),1,1);
		GeometricObject go3 = new GeometricObject(new Vertex(4,4),1,1);
		System.out.println(go1);
		System.out.println(go2);
		System.out.println("larger "+go1.isLargerThan(go2));
		System.out.println("above "+go1.isAbove(go2));
		System.out.println("underneath "+go1.isUnderneath(go2));
		System.out.println("left "+ go1.isLeftOf(go2));
		System.out.println("right "+ go1.isRightOf(go2));
		System.out.println("touches " +go1.touches(go2));
		go1.move();
		go2.move();
		System.out.println(go1);
		System.out.println(go2);		
	}//end of main
	
	
}//end of class