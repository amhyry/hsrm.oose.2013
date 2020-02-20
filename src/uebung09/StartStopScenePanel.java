package uebung09;

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
		jb = new JButton("Start");
		jb.addActionListener
		(new ActionListener() {
			public void actionPerformed (ActionEvent _) {
				if(sp.t.isRunning()){
					jb.setText("Stop");
					sp.t.stop();
				}
				else{
					jb.setText("Start");
					sp.t.start();				
				}
			}
		});
		this.add(sp);
		this.add(jb);
	}
	
	public static void main (String []args){
		Labyrinth lab = new Labyrinth("src/de/hsrm/cs/oose13/safe.txt");
		GeometricObjectsScene gos = new GeometricObjectsScene(lab.squares);
		StartStopScenePanel sssp = new StartStopScenePanel(gos);
		JFrame f = new JFrame();
		f.add(sssp);
		f.pack();
		f.setVisible(true);
	}
}
