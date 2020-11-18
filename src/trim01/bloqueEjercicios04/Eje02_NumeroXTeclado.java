package trim01.bloqueEjercicios04;

import java.util.Scanner;

public class Eje02_NumeroXTeclado {
	
	public static boolean esNumero(String numero) {
		boolean loEs = false;
		
		if(numero.matches("[0-9]{1,}")) {
			loEs = !loEs;
		}
		
		return loEs;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n;
		
		do {
			System.out.println("Introduce un número");
			n = sc.nextLine();
			
			if(esNumero(n)) {
				System.out.println("Muy bien, joven");
			} else {
				System.out.println("Eso no es numero!\n");
			}
		} while(!esNumero(n));
	}

}
