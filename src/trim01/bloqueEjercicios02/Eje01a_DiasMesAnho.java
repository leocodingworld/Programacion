package trim01.bloqueEjercicios02;

import java.util.Scanner;

public class Eje01_DiasMesAnho {
	
	public static boolean esBisiesto(short anho) {
		boolean es = false;
		
		if(anho % 4 == 0 && (anho % 100 != 0 || anho % 400 == 0)) {
			es = !es;
		}
		
		return es;
	}
	
	public static short diasAhno(short anho) {
		short dias = 365;
		
		if(esBisiesto(anho)) {
			dias++;
		}
		
		return dias;
	}

	public static byte diasMes(byte mes, short anho) {
		byte dias = 28;
		
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
		byte mes = sc.nextByte();
		
		System.out.print("Dime un año: ");
		short anyo = sc.nextShort();
		
		boolean es = esBisiesto(anyo);
		short diasA = diasAhno(anyo);
		byte diasM = diasMes(mes,anyo);
		
		System.out.println("El mes " + mes + " tiene " + diasMes(mes,anyo) + " días");
		System.out.println("El año " + anyo + " tiene " + diasAhno(anyo) + " días");

	}

}
