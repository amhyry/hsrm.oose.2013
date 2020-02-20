package uebung08;

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
	
	public ScenePanel(CollisionScene obj) {
		this.colscene = obj;
		t = new Timer(1000/36, new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				colscene.move();
				colscene.collisions();
				repaint();
			}
		});
	}
		
	public static void main (String [] args){
		Star [] goarray = new Star[20];
		Star go; //= new GeometricObject(new Vertex(Math.random()*30,Math.random()*20),new Vertex(Math.random()*10,Math.random()*10),Math.random()*30,Math.random()*30);
		for(int i = 0; i<goarray.length;i++){
			//go = new GeometricObject(new Vertex(Math.random()*30,Math.random()*20),new Vertex(Math.random()*5,Math.random()*5),Math.random()*40,Math.random()*30);
			go = new Star(new Vertex(Math.random()*30,Math.random()*20),new Vertex(Math.random()*5,Math.random()*5),(int)Math.random()*40,(int)Math.random()*30,(int)Math.random()*5);
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
		Dimension d = new Dimension();
		d.setSize(colscene.getWidth(), colscene.getHeight());
		return d;
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		colscene.paintAll(g);
	}
}
