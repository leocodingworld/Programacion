package trim01.bloqueEjercicios04;

public class Eje05_Fibonacci {
	
	public static int fiboItera(int n) {
		int n0 = 0;
		int n1 = 1;
		int f = 0;
		
		for(int i = 1; i <= n; i++) {
			f = n0 + n1;
			n0 = n1;
			n1 = f ;			
		}
		
		return f;
				
	}
	
	public static int fiboRecu(int n) {
		int f = 0;
		
		switch(n) {
			case 0:
				f = 0; 				
				break;
			case 1:
				f = 1;				
				break;
			default:
				f = fiboRecu(n-1) + fiboRecu(n-2);
				break;
		}
	
		return f;
	}
	
	public static void main(String[] args) {
		
		for(int i = 1; i <= 5; i++) {
			System.out.println(fiboItera(i-1));
		}
		
	}
	
}
