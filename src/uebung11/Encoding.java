package uebung11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Encoding{
	//Kostruktor der Klasse Encoding
    Encoding(){
       
    }
    //Methode zum umwandeln der Codierung der Datei
    public static void convert(String inFile,String outFile, String inCs, String outCs)throws Exception{
    	//inFile = Input File
    	//outFile = Output File
    	//inCs = Input Charset
    	//outCs = Output Charset
        InputStream inStream = new FileInputStream(inFile);
        // InputStream mit dem Inhalt des Input File f�llen (Bit Code)
        Reader r = new InputStreamReader(inStream,inCs);
        // Mit dem Reader wird Text erzeugt mit Hilfe des Charsets des Input File
        OutputStream outStream = new FileOutputStream(outFile);
        // OutputStream erzeugen mit Angabe des Namen der neuen Datei
        Writer w = new OutputStreamWriter(outStream,outCs);
        // Mit dem Writer die eingelesenen Zeichen mit dem neuen Charset in den erzeugten OutputStream schreiben
        int i = r.read();
        while (i >= 0){
            char c = (char) i;
            w.write(c);
            i = r.read();
        }
        //Reader und Writer schlie�en
        r.close();
      	w.close();
    }
   
}