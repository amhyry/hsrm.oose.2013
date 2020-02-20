package uebung06.name.panitz.oose13.dialogue;

public class ButtonLogicSmall extends ButtonLogic {

	String getDescription(){ return "in Kleinbuchstaben umwandeln"; }
	
	String eval(String x) { return x.toLowerCase(); }
	
	public static void main(String[]_){
		new Dialogue(new ButtonLogicSmall());
	}	
	
}
