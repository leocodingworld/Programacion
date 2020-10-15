package trim01;

import java.util.Scanner;

public class InvertirCifras {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Dame un numero ");
		int n = sc.nextInt();
		int n2 = n;

		int r = n%10;
		int inv = r;
		n /= 10;
		
		while (n > 0){
			r = n % 10;
			inv = inv * 10 + r;
			n /= 10;
		}
		
		System.out.println(inv);

	}

}
