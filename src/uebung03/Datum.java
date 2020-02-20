package uebung03;

class Datum{
	int tag, monat, jahr;
	
	Datum(int t, int m, int j){
		tag = t;
		monat = m;
		jahr = j;
	}

	public static void main (String args[]){
		Datum d1 = new Datum(20,4,2013);
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
		
	}
	
	public static void sysPrint(boolean b){
		if(b){ System.out.println("true"); }
		else{ System.out.println("false"); }
	}
	
	public boolean isEarlierThan(Datum that){
		if(this.jahr<that.jahr){return true;}
		if(this.monat<that.monat){return true;}
		if(this.tag<that.tag){return true;}
		return false;
	}
	
	public boolean isLaterThan(Datum that){
		if(this.jahr>that.jahr){return true;}
		if(this.monat>that.monat){return true;}
		if(this.tag>that.tag){return true;}
		return false;
	}
	
	public boolean sameDay(Datum that){
		if((this.jahr==that.jahr)&&(this.monat==that.monat)&&(this.tag==that.tag)){return true;}
		return false;
	}
	
	public boolean isLeapYear(){
		if((this.jahr%4 == 0) && ((jahr%100 != 0)||(jahr%400 == 0))){return true;}
		return false;
	}
	
	public int getAbsoluteDaysInYear(){
		if(this.isLeapYear()){return 365;}
		return 364;
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
		if(this.monat < 3){return -1;}
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
			default: return "Sonnabend";
		}//end of switch
	}//
	
	public Datum getEasterDay(){
		/*double a = jahr%19;
		double b = jahr%4;
		double c = jahr%7;
		double k = jahr/100;
		double p = (8*k + 13)/25;
		double q = k/4;
		double M = (15 + k - p - q)%30;	
		double	d = (19*a + M)%30;
		double N = (4 + k - q)%7;
		double e = (2*b + 4*c + 6*d + N)%7; 
		*/
		double k = jahr / 100;
		double m = 15 + (3*k + 3)/ 4 - (8*k + 13)/ 25;
		double s = 2 - (3*k + 3)/ 4;
		double a = jahr%19;
		double d = (19*a + m)% 30;
		double r = (d + a / 11) / (29*29)*12;
		double og = 21 + d - r;
		double sz = 7 - (jahr + jahr / 4 + s) % 7;
		double oe = 7 - (og - sz) % 7;
		int os = (int)og + (int)oe;
		int mon;
		
		if(os>31){
			mon = 4; 
			os = os-31;
		}
		else {
			mon = 3;
		}
		return new Datum((int)os,mon,jahr);	 
		
	}
	
	public String toString(){
		return tag + "." + monat + "." + jahr;
	}
}
