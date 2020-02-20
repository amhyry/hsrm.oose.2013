package uebung06.name.panitz.oose13.dialogue;

public class ButtonLogicEasterday extends ButtonLogic {

	String getDescription(){
		return "Osterdatum der Jahreszahl berechnen";
	}
	
	//String eval(String x) { return new Datum(1,1,new Integer(x).intValue()).getEasterDay().toString(); }
	
	//String eval(String x) { return new Datum(1,1,Integer.parseInt(x)).getEasterDay().toString(); }	
	
	String eval(String x) {
		int jahr = new Integer(x);
		return new Datum(1,1,jahr).getEasterDay().toString();
		}

	/*String eval(String x) {
		new Integer(x);
		int parseInt = Integer.parseInt(x);
		return new Datum(1,1,parseInt).getEasterDay().toString(); 
	}*/
	
	/*public static void main(String[]_){
		new Dialogue(new ButtonLogicEasterday());
	}*/	
	
	
	
}
