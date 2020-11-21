package trim01.bloqueEjercicios04;

import java.util.Scanner;

public class Eje01_MetodosPrimos {
	
	public static boolean esPrimo(int num){
		boolean primo = false;

		switch(num){
			case 2:
			case 3:
			case 5:
			case 7:
				primo = !primo;
			default:
				if(
					num % 2 != 0 &&
					num % 3 != 0 &&
					num % 5 != 0 &&
					num % 7 != 0
				){
					primo = !primo;	
				}
	
				break;
		}

		return primo;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Primer número: ");
		int n1 = sc.nextInt();

		System.out.print("Segundo número: ");
		int n2 = sc.nextInt();

		for(int i = n1; i <= n2; i++){
			if(esPrimo(i)){
				System.out.println(i);
			}
		}
	}

}
