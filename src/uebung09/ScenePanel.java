package uebung09;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ScenePanel extends JPanel {

	CollisionScene colscene;
	Timer t; 
	final int frameRate = 1000/36;
	
	public ScenePanel(CollisionScene obj) {
		this.colscene = obj;
		t = new Timer(frameRate, new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				colscene.move();
				colscene.collisions();
				repaint();
			}
		});
	}
		
	public static void main (String [] args){
		GeometricObject [] goarray = new GeometricObject[20];
		GeometricObject go; //= new GeometricObject(new Vertex(Math.random()*30,Math.random()*20),new Vertex(Math.random()*10,Math.random()*10),Math.random()*30,Math.random()*30);
		for(int i = 0; i<goarray.length;i++){
			//go = new GeometricObject(new Vertex(Math.random()*300,Math.random()*200),new Vertex(Math.random()*2,Math.random()*2),20,20);
			go = new Star(new Vertex(Math.random()*300,Math.random()*200),new Vertex(Math.random()*5,Math.random()*5),5,10,5);
			goarray[i] = go;
		}
		GeometricObjectsScene gos = new GeometricObjectsScene(goarray);
		ScenePanel sp = new ScenePanel(gos);
		JFrame f = new JFrame();
		f.add(sp);
		f.pack();
		f.setVisible(true);
		sp.t.start();
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(colscene.getWidth(),colscene.getHeight());
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		colscene.paintAll(g);
	}
	
}
