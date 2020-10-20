package trim01.bloqueEjercicios01;

import java.util.Scanner;

public class Eje05_InvertirCifras {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Dame un numero ");
        int n = sc.nextInt();
        int n2 = n; // n2 es el número que inicialmente se introduce por teclado
        // se guarda para compararlo más tarde
        int r = 0;
        
        int inv = 0;
        
        do {
            r = n % 10;
            inv = inv * 10 + r;
            n /= 10;
        } while (n > 0);

        System.out.println(inv);

	}

}
