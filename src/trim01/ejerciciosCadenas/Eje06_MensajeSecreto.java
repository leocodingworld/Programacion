package trim01.ejerciciosCadenas;

import java.util.Scanner;

public class Eje06_MensajeSecreto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el mensaje secreto: ");
        String frase = sc.nextLine();
        String msg = "";
        
        for(int i = 0; i <= frase.length(); i++){
            if((i + 1) % 5 == 0){
                msg += frase.charAt(i);
            }
        }
        
        System.out.println("El mensaje es: " + msg);

	}

}
