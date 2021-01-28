package trim02.poo.utilidades;

import java.util.Random;
import java.util.Scanner;

public class Utils {
	
	public static boolean equivalentes(int[][] m1, int[][] m2){
		boolean equivalente;
		boolean igual = true;
		
		if(m1.length == m2.length && m1[0].length == m2[0].length){
			
			for(int i = 0; i < m1.length && igual; i++){
				
				for(int j = 0; j < m1.length && igual; j++){
					
					if(m1[i][j] != m2[i][j]){
						igual = false;
					}
					
				}
				
			}
			
		}
		
		if(igual){
			equivalente = true;
		} else {
			equivalente = false;
		}
		
		return equivalente;
	}
	
	public static int aleatorio(byte limite){
		Random r = new Random();
				
		return r.nextInt(limite);
	}
	
	public static int aleatorio(byte inf, byte sup){
		Random r = new Random();
		
		return r.nextInt(sup - inf) + inf;
	}
	
	public static String cifradoCesar(String frase){
		String palabra = "";
		char carac;
		int clave;
		final byte DES = 3;
		
		
		for(int i = 0; i < frase.length(); i++){
			carac = frase.charAt(i);
			clave = (int) carac;
			clave += DES;
			carac = (char) clave;

			palabra += Character.toString(carac);
		}

		return palabra;
	}
	
	public static String descifradoCesar(String frase){
		String palabra = "";
		char carac;
		int clave;
		final byte DES = -3;
		
		
		for(int i = 0; i < frase.length(); i++){
			carac = frase.charAt(i);
			clave = (int) carac;
			clave += DES;
			carac = (char) clave;

			palabra += Character.toString(carac);
		}

		return palabra;
	}
	
	public static int menu(int valor){
		Scanner sc = new Scanner(System.in);
		int numUser;
		
		do {
			System.out.println("Elige una opción");
			numUser = sc.nextInt();
			
			if(numUser < 1 || numUser > valor){
				System.out.println("Opción no válida.");
			}
		} while (numUser >= 1 && numUser <= valor);
		
		return numUser;
	}
	
	public static void sacarMatrix(int[][] m) {
		
		for(int i = 0; i < m.length; i++) {
			
			for(int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] +"\t");
			}
			
			System.out.println("");	
		}
		
	}
}
