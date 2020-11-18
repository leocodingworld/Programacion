package trim01.BloqueEjercicios4;

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
		int n1;
		int n2;

		System.out.print("Primer número: ");
		n1 = sc.nextInt();

		System.out.print("Segundo número: ");
		n2 = sc.nextInt();

		for(int i = n1; i <= n2; i++){
			if(esPrimo(i)){
				System.out.println(i);
			}
		}
	}

}
