package uebung11;

public class EncodeTxt {
    public static void main (String args[]) throws Exception{
    	// test1.txt mit dem Charset UTF-8 wird mit ISO-8859-11 in der neuen Datei test2.text gespeichert
    	Encoding.convert("test1.txt",Name.FileName()+".txt","UTF-8","ISO-8859-11");
        
    }
}
