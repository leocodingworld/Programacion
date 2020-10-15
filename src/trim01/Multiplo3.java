package trim01;

import java.util.Scanner;

public class Multiplo3 {

	public static int sumarCifras(int n) {
		int r = 0, s = 0;
		
		do {
			r = n % 10;
			n /= 10;
			
			s += r;
		} while (n != 0);
		
		return s;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int s = 0;
		
		

	}

}
