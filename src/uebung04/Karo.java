package uebung04;

public class Karo {
	
	public static String karo(int columns,int rows){
		String temp = "";
		for(int y = 0;y<rows;y++){
			for(int x = 0;x<columns;x++){ 
				if(x%2==0){	
					temp = temp + "X";
				}
				else{
					temp = temp + "O";
				}
			}
			temp = temp+"\n";
		}
		return temp;
	}
	

	/*public static int quersumme(int n){	
		if(n<0){return quersumme(-n);}	
		if(n<10){return n;}	
		return n%10 + quersumme(n/10);	
	}*/
	
	public static int quersumme(int n){
		int temp = 0;
		if(n<0){n = -n;}
		while(n!=0){
			temp = temp + (n%10);
			n = n/10;
		}
		return temp;
	}
	
	public static void main (String args[]){	
		System.out.println(Karo.karo(20,6));
		System.out.println(Karo.quersumme(222));
	}	
	

}
