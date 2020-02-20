package uebung09;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import uebung09.util.*;

public class Labyrinth extends JPanel {

	GeometricObject[] squares;
	final double squareborder = 20;

	public Labyrinth(String textpath) {
		String lab[] = FileUtil.readTextLines(textpath);
		List<GeometricObject> list = new ArrayList<>();

		for (int y = 0; y < lab.length; y++) {
			for (int x = 0; x < lab[y].length(); x++) {
				if (lab[y].charAt(x) == 'W') {
					list.add(new GeometricObject(new Vertex((squareborder + 1)
							* x, (squareborder + 1) * y), squareborder,
							squareborder));
				}
			}
		}
		squares = new GeometricObject[list.size()];

		for (int i = 0; i < squares.length; i++) {
			squares[i] = list.get(i);
		}
	}
}
