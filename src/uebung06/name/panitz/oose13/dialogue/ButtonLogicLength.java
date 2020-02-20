package uebung06.name.panitz.oose13.dialogue;

public class ButtonLogicLength extends ButtonLogic {

	String getDescription(){ return "String länge berechnen"; }
	
	String eval(String x) { return ""+x.length(); }
	
	/*public static void main(String[]_){
		new Dialogue(new ButtonLogicLength());
	}*/	
	
}
