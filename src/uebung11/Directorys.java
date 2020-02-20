package uebung11;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Directorys {
	//Konstruktor der Klasse Directorys
	public Directorys() {

	}
	
	public static List<File> getFileList(File startFile, List<File> result) {
		File[] files = startFile.listFiles();
		for (File x : files) {
			if (x.isDirectory()) {
				result.add(x);
				getFileList(x, result);
			} else {
				result.add(x);
			}

		}
		return result;
	}

	public static List<File> getFileList(String startFile) {
		return getFileList(new File(startFile), new ArrayList<File>());
	}

	public static List<File> getFileList(File startFile) {
		return getFileList(startFile, new ArrayList<File>());
	}

	public static List<File> getFileList() {
		return getFileList(new File("."));
	}

}