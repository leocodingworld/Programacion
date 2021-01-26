package trim01.bloqueEjercicios01;

import java.util.Scanner;

public class Eje04_SumaCifras {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un número");
		int num = sc.nextInt();
		int r = 0, s = 0; // r es el resto y s la suma de las cifras
		
		do {
			r = num % 10;
			num /= 10;
			
			if( r % 2 != 0) {
				s += r;
			}
		} while (num != 0);

		System.out.println(s);
	}

}
