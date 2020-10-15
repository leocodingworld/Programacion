package trim01;

import java.util.Scanner;

public class Eje07_Multiplo3 {

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
		
		System.out.println("Introduce un numero");
		int num = sc.nextInt();
		int s = num;
		
		do {
			s = sumarCifras(s);
		} while (s > 10);
		
		if(s == 3 || s == 6 || s == 9) {
			System.out.println("Es múltiplo");
		}

	}

}
