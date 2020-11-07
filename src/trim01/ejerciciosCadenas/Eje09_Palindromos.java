package trim01.ejerciciosCadenas;

import java.util.Scanner;

public class Eje09_Palindromos {
	
	public static String limpiarFrase(String frase) {
		String fraseLimpia;
		
		fraseLimpia = frase.replace(" ","");
		fraseLimpia = fraseLimpia.replace("á","a");
		fraseLimpia = fraseLimpia.replace("é","e");
		fraseLimpia = fraseLimpia.replace("í","i");
		fraseLimpia = fraseLimpia.replace("ó","o");
		fraseLimpia = fraseLimpia.replace("ú","u");
		fraseLimpia = fraseLimpia.toLowerCase();
		
		return fraseLimpia;
	}
	
	public static String invertirFrase(String frase) {
		String fraseInv = "";
		String frase2 = limpiarFrase(frase);
		
		for(int i = frase2.length() - 1; i >= 0; i--) {
			fraseInv += frase2.charAt(i);			
		}
		
		return fraseInv;		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
        
        System.out.print("Dime una frase y te la analizo: ");
        String fraseU = sc.nextLine();
        
        if(limpiarFrase(fraseU).equals(invertirFrase(fraseU))){
            System.out.println("Esta frase es un palíndromo");
        } else {
            System.out.println("Es una frase corriente");
        }
        
	}
	
}
