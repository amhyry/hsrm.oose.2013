package uebung11;

import java.io.*;
import java.util.*;

public class FileLister {

	public static List<File> getFileList() throws Exception{
		return getFileList(".");
	}
		
	public static List<File> getFileList(String fileName) throws Exception{
			return getFileList(new File(fileName));
	}
	
	public static List<File> getFileList(File startFile) throws Exception{
		return getFileList(startFile, new ArrayList<File>());
	}
	
	public static List<File> getFileList(File startFile, List<File> result) throws Exception{	
		File file[] = startFile.listFiles();
		for(File f : file){
			if(f.isDirectory()) {
				getFileList(f,result);
			}
			result.add(f);
		}
		return result;
	}
	
	static void convert(String inFile, String outFile, String inEnc,String outEnc) throws Exception{ 
		Reader is = new InputStreamReader(new FileInputStream(inFile),inEnc);
		Writer os = new OutputStreamWriter(new FileOutputStream(outFile),outEnc);
		int i = 0;
		do{
			i = is.read();
			os.write(i);
		}while(i>=0);
		is.close();
		os.close();
	}
	
	public static void main (String args[]) throws Exception{
		List<File> list;
		File f = new File("/Users/Gooseberry69/Studium/Wirtschaftsinfo1/oose");
		list = FileLister.getFileList();
		for(File l : list){
			System.out.println(l.getPath());
		}
	}


}
