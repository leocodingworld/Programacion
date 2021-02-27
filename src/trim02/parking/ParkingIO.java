package trim02.parking;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("serial")
public class ParkingIO {	
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);		
		Conductor user = crearConductor();

		ArrayList<Vehiculo> coches = new ArrayList<Vehiculo>() {{}};
		ArrayList<Vehiculo> minibuses = new ArrayList<Vehiculo>() {{}};
		HashMap<String,ArrayList<Vehiculo>> listado = new HashMap<String,ArrayList<Vehiculo>>() {{
			put("coches",coches);
			put("minibuses",minibuses);
		}};
		
		String opt = "";
				
		do {
			System.out.println("1.- Añadir un vehículo");
			System.out.println("2.- Sacar el listado");
			System.out.println("3.- Eliminar vehiculo");
			System.out.println("0.- Salir");
			
			System.out.print("\nElige una opción:");
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
		Scanner sc = new Scanner(System.in);
		Conductor nuevo = new Conductor();
		
		System.out.println("Para usar el sistema, debe introducir sus datos como conductor.");
		
		return nuevo;
	}	
	
}
