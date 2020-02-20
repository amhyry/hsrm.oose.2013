package uebung04;

class Datum{
	int tag, monat, jahr;
	
	Datum(int t, int m, int j){
		tag = t;
		monat = m;
		jahr = j;
	}

	public static void main (String args[]){
		Datum d1 = new Datum(20,3,2014);
		Datum d2 = new Datum(10,4,2013);
		
		System.out.println(d1 + " / " + d2);
		System.out.print("Frueher: ");
		sysPrint(d1.isEarlierThan(d2));
		System.out.print("Spaeter: ");
		sysPrint(d1.isLaterThan(d2));
		System.out.print("Selber Tag: ");
		sysPrint(d1.sameDay(d2));
		System.out.print("Schaltjahr: ");
		sysPrint(d1.isLeapYear());
		System.out.println("Tage im Jahr: "+d1.getAbsoluteDaysInYear());
		System.out.println("Tage im Monat: "+d2.getDaysInMonth());
		System.out.println(d1.wochenTagAlsString());
		System.out.println("Ostern: "+ d1.getEasterDay());
		System.out.println(d2.monthToString());
		System.out.println(d2.monthAsHTML());
		
	}
	
	public static void sysPrint(boolean b){
		if(b){ System.out.println("true"); }
		else{ System.out.println("false"); }
	}
	
	public boolean isEarlierThan(Datum that){
		if(this.jahr<that.jahr){return true;}
		if(this.jahr>that.jahr){return false;}
		if(this.monat<that.monat){return true;}
		if(this.monat>that.monat){return false;}
		if(this.tag<that.tag){return true;}
		return false;
	}
	
	public boolean isLaterThan(Datum that){
		if(this.jahr>that.jahr){return true;}
		if(this.jahr<that.jahr){return false;}
		if(this.monat>that.monat){return true;}
		if(this.monat<that.monat){return false;}
		if(this.tag>that.tag){return true;}
		return false;
	}
	
	public boolean sameDay(Datum that){
		return (this.jahr==that.jahr)&&(this.monat==that.monat)&&(this.tag==that.tag);
	}
	
	public boolean isLeapYear(){
		return (this.jahr%4 == 0) && ((jahr%100 != 0)||(jahr%400 == 0));	
	}
	
	public int getAbsoluteDaysInYear(){
		if(this.isLeapYear()){return 366;}
		return 365;
	}
	
	public int getDaysInMonth(){
		if((this.monat == 2)&&(this.isLeapYear())){return 29;}
		if((this.monat == 2)&&(!this.isLeapYear())){return 28;}
		if((this.monat%2!=0)&&(this.monat<8)){return 31;}
		if((this.monat%2==0)&&(this.monat>7)){return 31;}
	
		return 30;
	}
	
	
	
	public int tagesziffer(){
		return this.tag%7;
	}
	
	public int monatsziffer(){
		switch (this.monat){
			case 1: return 0;
			case 2: return 3;
			case 3: return 3;
			case 4: return 6;
			case 5: return 1;
			case 6: return 4;
			case 7: return 6;
			case 8: return 2;
			case 9: return 5;
			case 10: return 0;
			case 11: return 3;
			default: return 5;
		}//end of switch			
	}
	
	public int jahresziffer(){
		String s = (new Integer(this.jahr)).toString();		
		s = s.substring(2);
		//System.out.println("jahresziffer"+s);
		int temp = Integer.parseInt(s);
		return (temp+(temp/4))%7;
	}
	
	public int jahrhundertZiffer(){
		String s = (new Integer(this.jahr)).toString();		
		s = s.substring(0,2);
		//System.out.println("Jahrhunderziffer"+s);
		int temp = Integer.parseInt(s);	
		return (3-(temp%4))*2;
	}
	
	public int schaltjahrKorrektur(){
		if((this.isLeapYear())&&(this.monat < 3)){return -1;}
		else{return 0;}
	}	
	
	public int wochentag(){	
		return (tagesziffer()+monatsziffer()+jahresziffer()+jahrhundertZiffer()+schaltjahrKorrektur())% 7;
	}
		
	public String wochenTagAlsString(){
		int wtag = wochentag();
		switch (wtag){
			case 0: return "Sonntag";
			case 1: return "Montag";
			case 2: return "Dienstag";
			case 3: return "Mittwoch";
			case 4: return "Donnerstag";
			case 5: return "Freitag";
			default: return "Samstag";
		}//end of switch
	}//
	
	public Datum getEasterDay(){
		int k = jahr / 100;
		int m = 15 + (3*k + 3)/ 4 - (8*k + 13)/ 25;
		int s = 2 - (3*k + 3)/ 4;
		int a = jahr%19;
		int d = (19*a + m)% 30;
		int r = (d + a / 11) / (29*29)*12;
		int og = 21 + d - r;
		int sz = 7 - (jahr + jahr / 4 + s) % 7;
		int oe = 7 - (og - sz) % 7;
		int os = og + oe;
		int mon;	
		if(os>31){
			mon = 4; 
			os = os-31;
		}
		else {
			mon = 3;
		}
		return new Datum(os,mon,jahr);	 	
	}
	
	public String monthToString(){
		String temp = "";
		for(int i = 1; i<=this.getDaysInMonth();i++){	//durchlauf für alle tage im monat 1-ende
			Datum d = new Datum(i,this.monat,this.jahr);	//erstelle datum mit monatstag
			 temp = temp + d.wochenTagAlsString() + " der " + d.toString() + "\n";	//erstelle String
		}
		return temp;	//rückgabe von String
	}
	
	public String monthAsHTML(){
		String temp = "<table>\n<tr><th>Mo</th><th>Di</th><th>Mi</th><th>Do</th><th>Fr</th><th>Sa</th><th>So</th></tr>\n<tr>";
		Datum d = new Datum(1,this.monat,this.jahr);	
		for(int x = 1;x<=8;x++){
			if(d.wTagInt() == x){
				for(int i = 1 ;i<=d.getDaysInMonth(); x++,i++){ 
					d = new Datum(i,this.monat,this.jahr);
					temp = temp + "<td>" + d.tag + "</td>";
					if(x==7){
						temp = temp + "</tr>\n<tr>";
						x=0;
					}//end of if
				}//end of for
				return temp + "</tr>\n</table>"; 
			}
			else{
				temp = temp + "<td> </td>";	
			}
		}
	
		return null;	
	}

	public int wTagInt(){
		int wtag = wochentag();
		switch (wtag){
			case 0: return 7;
			case 1: return 1;
			case 2: return 2;
			case 3: return 3;
			case 4: return 4;
			case 5: return 5;
			default: return 6;
		}//end of switch
	}//		
	
	public String toString(){
		return tag + "." + monat + "." + jahr;
	}
}
