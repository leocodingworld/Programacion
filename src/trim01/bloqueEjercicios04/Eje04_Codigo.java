package trim01.bloqueEjercicios04;

import java.util.Scanner;

public class Eje04_Codigo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] codigo = {0,4,9,3,5};
		int intentos = 3;
		int aciertos = 0;
		int clave;
		
		do {
			
			for(int i = 0; i < codigo.length; i++) {
				System.out.print("Introducir digito n" + (i + 1) + " ");
				clave = sc.nextInt();
				
				if(codigo[i] == clave){
					System.out.println("Correcto");
					aciertos++;
				}
				
				if(clave > codigo[i]){
					System.out.println("Es menor");
				}
				
				if(clave < codigo[i]){
					System.out.println("Es mayor");
				}
			}
			
			if(aciertos != 5) {
				System.out.println("Contraseña incorrecta\n");
				aciertos = 0;
			}
			
			intentos--;
		} while(intentos > 0 && aciertos < 5);
		
		System.out.println();
		
		if(intentos == 0 && aciertos == 0) {
			System.out.println("Acceso Denegado");
		} else {
			System.out.println("Acceso Concedido");
		}

	}

}
