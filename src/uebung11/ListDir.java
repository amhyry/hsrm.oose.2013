package uebung11;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListDir {
    
    public static void main (String args[]){
        List<File> fileList = new ArrayList<>();
        //Vollst�ndiger Pfade des Aufzulistenden Verzeichnisses
        File f = new File (".");
        Directorys.getFileList(f,fileList);
        fileList.toString();
        for(int i = 0; i < fileList.size();i++){
            System.out.println(fileList.get(i).getAbsolutePath());
        }
    }
    
}