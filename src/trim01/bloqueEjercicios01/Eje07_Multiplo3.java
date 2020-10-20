package trim01.bloqueEjercicios01;

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
		
		do {
			num = sumarCifras(num);
		} while (num > 10);
		
		if(num == 3 || num == 6 || num == 9) {
			System.out.println("Es múltiplo");
		}

	}

}
