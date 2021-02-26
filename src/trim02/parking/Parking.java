package trim02.parking;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Parking {
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		String opt = "";
		Vehiculo user;
				
		do {
			System.out.println("1.- Añadir un vehículo");
			System.out.println("2.- Sacar el listado");
			System.out.println("3.- Eliminar vehiculo");
			System.out.println("0.- Salir\n");
			
			System.out.print("Elige una opción:");
			opt = sc.nextLine();
			
			switch(opt) {
				case "1":
					
					break;
				case "2":
					break;
				case "3":
					break;
				case "0":
					break;
				default:
					break;
			}
			
			System.out.println();
			
		} while(!opt.equals("0"));
	}
	
	public static boolean validarTelefono(String telefono) {
		return telefono.matches("[679][0-9]{8}");
	}
	
	public static boolean validarMatricula(String matricula) {
		return matricula.matches("[0-9]{4}");
	}
	
	public static boolean validarLongitud(float longitud) {
		return longitud >= 2.5f && longitud <= 6.0f;
	}
	
	public static boolean validarPuertas(int puertas) {
		return puertas >= 5 && puertas <= 25;
	}
	
	public static Conductor crearConductor() {
		Conductor nuevo = new Conductor();
		
		return nuevo;
	}	
	
	public static void main(String[] args) {
		
	}

}
