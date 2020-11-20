package trim01.bloqueEjercicios04;

public class Eje05_Fibonacci {
	
	public static void fiboItera(int n) {
		int[] f = new int[n];
		f[0] = 0;
		f[1] = 1;
		
		System.out.println(f[0]);
		System.out.println(f[1]);
		
		for(int i = 2; i < n; i++) {
			f[i] = f[i-1] + f[i-2];
			
			System.out.println(f[i]);
		}
		
				
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
		fiboItera(8);
		
		System.out.println();
		
		for(int i = 0; i < 8; i++) {
			System.out.println(fiboRecu(i));
		}
	}
	
}
