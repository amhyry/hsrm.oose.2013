package uebung09;

import java.awt.Graphics;

public class GeometricObjectsScene implements CollisionScene {
	public GeometricObject[] golist;

	public GeometricObjectsScene(GeometricObject[] golist) {
		this.golist = golist;
	}

	@Override
	public void collisions() {
		GeometricObject frame = new GeometricObject(new Vertex(0, 0), this.getHeight(),this.getWidth());
		GeometricObject leftframe = new GeometricObject(new Vertex(0, 0), this.getHeight(),0);
		GeometricObject rightframe = new GeometricObject(new Vertex(this.getWidth(), 0), this.getHeight(),0);
		GeometricObject upperframe = new GeometricObject(new Vertex(0, 0),0 ,this.getWidth());
		GeometricObject downframe = new GeometricObject(new Vertex(0, this.getHeight()), 0,this.getWidth());
		
		
		for (int i = 0; i < golist.length; i++) {
			//if (golist[i].isLeftOf(frame) || golist[i].isRightOf(frame)) {
			if (golist[i].touches(leftframe)||(golist[i].touches(rightframe))) {
				golist[i].moving.x = -golist[i].moving.x;
			}
			//if (golist[i].isAbove(frame) || golist[i].isUnderneath(frame)) {
			if (golist[i].touches(upperframe)||(golist[i].touches(downframe))) {
				golist[i].moving.y = -golist[i].moving.y;
			}
		}
		
		for (int i = 0; i < golist.length; i++) {
			for (int x = i+1; x < golist.length; x++) {
				if (golist[i].touches(golist[x])){
					golist[i].moving.x = -golist[i].moving.x;
					golist[i].moving.y = -golist[i].moving.y;
					golist[x].moving.x = -golist[x].moving.x;
					golist[x].moving.y = -golist[x].moving.y;
				}
				
			}
		}	
	}

	@Override
	public void move() {
		for (GeometricObject go : golist) {
			go.move();
		}
	}

	@Override
	public void paintAll(Graphics g) {
		for (GeometricObject go : golist) {
			go.paintMeTo(g);
		}
	}

	@Override
	public int getWidth() {
		double width = 0;
		for (int i = 0; i < golist.length; i++) {
			if(width < golist[i].width + golist[i].corner.x){
				width = golist[i].width + golist[i].corner.x;
			}
		}
		return (int) Math.round(width-1);
	}

	@Override
	public int getHeight() {
		double height = 0;
		for (int i = 0; i < golist.length; i++) {
			if(height < golist[i].height + golist[i].corner.y){
				height = golist[i].height + golist[i].corner.y;
			}
		}
		return (int) Math.round(height-1);
	}

}
