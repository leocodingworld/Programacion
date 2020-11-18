package trim01.bloqueEjercicios02;

import java.util.Scanner;

public class Eje01a_DiasMesAnho {
	
	public static boolean esBisiesto(int anho) {
		boolean es = false;
		
		if(anho % 4 == 0 && (anho % 100 != 0 || anho % 400 == 0)) {
			es = !es;
		}
		
		return es;
	}
	
	public static int diasAhno(int anho) {
		int dias = 365;
		
		if(esBisiesto(anho)) {
			dias++;
		}
		
		return dias;
	}

	public static int diasMes(int mes, int anho) {
		int dias = 28;
		
		switch (mes) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				dias = 31;
				break;
			case 2:
				if (esBisiesto(anho)) {
					dias = 29;
				}				
				break;
			default:
				dias = 30;
				break;
		}
		
		return dias;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime un mes: ");
		int mes = sc.nextInt();
		
		System.out.print("Dime un año: ");
		int anyo = sc.nextInt();
		
		System.out.println("El mes " + mes + " tiene " + diasMes(mes,anyo) + " días");
		System.out.println("El año " + anyo + " tiene " + diasAhno(anyo) + " días");

	}
	
}
