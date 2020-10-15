package trim01;

import java.util.Scanner;

public class Eje01_EsPar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un número y te diré si es par");
		int num = sc.nextInt();
		
		if (num % 2 == 0) {
			System.out.println("Es par");
		} else {
			System.out.println("No es par");
		}
		

	}

}
