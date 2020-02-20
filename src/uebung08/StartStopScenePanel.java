package uebung08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartStopScenePanel extends JPanel {

	ScenePanel sp;
	JButton jb;

	public StartStopScenePanel(CollisionScene obj) {
		sp = new ScenePanel(obj);
		jb = new JButton("Start/Stop");
		jb.addActionListener
		(new ActionListener() {
			public void actionPerformed (ActionEvent _) {
				if(sp.t.isRunning()){
					sp.t.stop();
				}
				else{
					sp.t.start();
				}
			}
		});
		this.add(sp);
		this.add(jb);
	}
	
	public static void main (String []args){
		GeometricObject [] goarray = new GeometricObject[20];
		GeometricObject go = new GeometricObject(new Vertex(Math.random()*30,Math.random()*20),new Vertex(Math.random()*5,Math.random()*5),Math.random()*30,Math.random()*30);
		for(int i = 0; i<goarray.length;i++){
			go = new GeometricObject(new Vertex(Math.random()*200,Math.random()*200),new Vertex(Math.random()*5,Math.random()*5),Math.random()*40,Math.random()*30);
			goarray[i] = go;
		}
		GeometricObjectsScene gos = new GeometricObjectsScene(goarray);
		StartStopScenePanel sssp = new StartStopScenePanel(gos);
		JFrame f = new JFrame();
		f.add(sssp);
		f.pack();
		f.setVisible(true);
	}
}
