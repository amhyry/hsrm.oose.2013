package uebung06.name.panitz.oose13.dialogue;

public class ButtonLogicDepp extends ButtonLogic {

	String getDescription(){ return "Enthaelt depp"; }
	
	String eval(String x){ return "" + x.contains("depp"); }
	
	/*public static void main(String[]_){
		new Dialogue(new ButtonLogicDepp());
	}*/	
	
}
