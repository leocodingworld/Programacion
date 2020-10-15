package trim01;

import java.util.Scanner;

public class Eje06_EsCapicua {

	public static int invertirCifras(int n) {
		int n2 = n;

		int r = n%10;
		int inv = r;
		n /= 10;
		
		while (n > 0){
			r = n % 10;
			inv = inv * 10 + r;
			n /= 10;
		}
		
		return inv;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un numero");
		int num = sc.nextInt();
		
		if(num == invertirCifras(num)) {
			System.out.println("Es capicua");
		} else {
			System.out.println("No es capicua");
		}
		

	}

}
