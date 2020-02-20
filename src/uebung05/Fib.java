package uebung05;

public class Fib {

	int n1, n2;
	
	public Fib() {
		n1 = 1;
		n2 = 0;
	}
	
	public static long fib(int n){
		if(n <= 1) return n;
		else{ return fib(n-1)+fib(n-2);}	
	}
	
	public long nextFib(){
		int n3 = n2 + n1;
		n2 = n1;
		n1 = n3;
		return n2;
	}

	public static void main(String[] args) {
		System.out.println(Fib.fib(10));
		Fib d1 = new Fib();
		for(int i = 0;i<10;i++) System.out.println(d1.nextFib());
	}
}
