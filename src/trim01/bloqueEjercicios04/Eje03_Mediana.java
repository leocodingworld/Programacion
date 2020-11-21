package trim01.bloqueEjercicios04;

import java.util.Random;

public class Eje03_Mediana {

	public static int[] order(int[] a){
		int[] ordenado = new int[a.length];
		int menor = a[0];
		int menorAnterior = -1 ;
		
		for(int i = 0; i < a.length; i++) {			
			for (int j = 0; j < a.length; j++){
				if(menor > a[j]){
					if(menor != menorAnterior) {
						menor = a[j];
					}
				}
			}
			
			ordenado[i] = menor;
			menorAnterior = menor;
		}
				
		return ordenado;
	}

	public static int[] generador(int n) {
		Random r = new Random();
		int[] nuevo = new int[n];
		
		for(int i = 0; i < n; i++) {
			nuevo[i] = r.nextInt(100);
		}
		
		return nuevo;
	}
	
	public static void main(String[] args) {
		int[] a = order(generador(1000));
		
		for(int i: a){
			System.out.println(i);
		}
	}

}
