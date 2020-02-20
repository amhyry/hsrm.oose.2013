package uebung11;

import java.util.Date;


public class Name {
	@SuppressWarnings("deprecation")
	static int hou = new Date().getHours();
	@SuppressWarnings("deprecation")
	static int min = new Date().getMinutes();
	@SuppressWarnings("deprecation")
	static int sec = new Date().getSeconds();
	
	public static String FileName(){
	return hou+"h"+min+"m"+sec+"s";
	}
}
