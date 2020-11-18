package trim01.bloqueEjercicios04;

public class Eje05_Fibonacci {
	
	public static void fiboItera(int n) {
		int n0 = 0, n1 = 1, suma = 0;		
		
		for(int i = 1; i <= n; i++) {
			System.out.println(suma);
			suma = n0 + n1;
			n0 = n1;
			n1 = suma ;
		}
				
	}
	
	public static void fiboRecu(int n) {
		
	}
	
	public static void main(String[] args) {
		fiboItera(10);
		
	}
	
}
