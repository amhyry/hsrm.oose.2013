package uebung08;

import java.awt.Graphics;

public class GeometricObjectsScene implements CollisionScene {
	public GeometricObject[] golist;

	public GeometricObjectsScene(GeometricObject[] golist) {
		this.golist = golist;
	}

	@Override
	public void collisions() {
		GeometricObject frame = new GeometricObject(new Vertex(0, 0), this.getHeight(),this.getWidth());
		for (int i = 0; i < golist.length; i++) {
			if (golist[i].isLeftOf(frame) || golist[i].isRightOf(frame)) {
				golist[i].moving.x = -golist[i].moving.x;
			}
			if (golist[i].isAbove(frame) || golist[i].isUnderneath(frame)) {
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
		for (int i = 0; i < golist.length; i++) {
			golist[i].move();
		}
	}

	@Override
	public void paintAll(Graphics g) {
		for (int i = 0; i < golist.length; i++) {
			g.fillRect((int) golist[i].corner.x, (int) golist[i].corner.y,
					(int) golist[i].width, (int) golist[i].height);
		}
	}

	@Override
	public int getWidth() {
		int width = 0;
		for (int i = 0; i < golist.length; i++) {
			width = width + (int)golist[i].width;
		}
		return width;
	}

	@Override
	public int getHeight() {
		int height = 0;
		for (int i = 0; i < golist.length; i++) {
			height = height + (int)golist[i].height;
		}
		return height;
	}

}
