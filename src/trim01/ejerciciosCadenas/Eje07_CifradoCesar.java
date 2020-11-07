package trim01.ejerciciosCadenas;

import java.util.Scanner;

public class Eje07_CifradoCesar {
	
	public static String cifradoCesar(String frase, char accion){
        char clave;
        int codigo;
        byte des = 3;
        String fraseCod = "";
        
        if(accion == 'd'){
            des = -3;
        }
        
        for(int i = 0; i < frase.length(); i++){
            clave = frase.charAt(i);
            
            switch(clave){
                case 'x':
                    codigo = (int)'a';
                    break;
                case 'y':
                    codigo = (int)'b';
                    break;
                case 'z':
                    codigo = (int)'c';
                    break;
                case 'ñ':
                    codigo = (int)'n';
                    codigo += des;
                    break;
                default:
                    codigo = (int) clave;
                    codigo += des;
                    break;
            }
            
            clave = (char) codigo;
            
            fraseCod += clave;
            
        }
        
        return fraseCod;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int opt;
        String frase;
        
        do {            
            System.out.println("\t1.- Cifrar frase");
            System.out.println("\t2.- Descrifrar frase");
            System.out.println("\t3.- Salir");
            System.out.print("Elige una opción: ");
            opt = sc.nextInt();
            
            switch(opt){
                case 1:
                    System.out.print("Introduce la frase: ");
                    frase = sc.next();
                    
                    System.out.println(cifradoCesar(frase,'c'));
                    break;
                case 2:
                    System.out.print("Introduce la frase: ");
                    frase = sc.next();
                    
                    System.out.println(cifradoCesar(frase,'d'));
                    break;
                case 3:
                    System.out.println("Hasta Luego");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }           
            
        } while (opt != 3);

	}

}
