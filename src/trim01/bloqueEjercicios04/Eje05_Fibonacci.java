package trim01.bloqueEjercicios04;

import java.util.Scanner;

public class Eje05_Fibonacci {
	
	public static void iterativo(int n) {
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
	
	public static int recursivo(int n) {
		int f = 0;
		
		switch(n) {
			case 0:
				f = 0; 				
				break;
			case 1:
				f = 1;				
				break;
			default:
				f = recursivo(n-1) + recursivo(n-2);
				break;
		}
	
		return f;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fn = 0;
		int opt = 0;

		do {
			System.out.println("1.- Fibonacci Iterativo");
			System.out.println("2.- Fibonacci Recursivo");
			System.out.println("3.- Salir");

			System.out.print("Escoge una opción: ");
			opt = sc.nextInt();

			if(opt != 3){
				System.out.print("Indica hasta que elemento quieres: ");
				fn = sc.nextInt();
			}
			
			switch(opt){
				case 1:
					iterativo(fn);
					break;
				case 2:

					for(int i = 0; i <= fn; i++){
						System.out.println(recursivo(i));
					}

					break;
			}

			System.out.println("");
		} while(opt != 3);
	}
	
}
