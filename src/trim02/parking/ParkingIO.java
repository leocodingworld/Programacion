package trim02.parking;

import java.util.Scanner;
import java.util.HashMap;

@SuppressWarnings("serial")
public class ParkingIO {	
	
	private static final Conductor CONDUCTOR = new Conductor("Pepito","Perez","942456789");
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);

		HashMap<String,Vehiculo> vehiculos = new HashMap<String,Vehiculo>() {{
			put("Ford", new Coche(CONDUCTOR, "1038SOP", 2.7f));
			put("Seat", new Coche(CONDUCTOR, "0254UWU", 3.0f));
			put("Volkswagen", new Coche(CONDUCTOR,"6669OWO", 5.5f));
			
			put("Clásico", new Minibus(CONDUCTOR,"8354SDK",10));
			put("Urbano", new Minibus(CONDUCTOR,"0173XCS",15));
			put("Extendido", new Minibus(CONDUCTOR,"6503ASD",25));
		}};
		
		String opt = "";
				
		do {
			System.out.println("1.- Añadir un vehículo");
			System.out.println("2.- Sacar el listado");
			System.out.println("3.- Eliminar vehiculo");
			System.out.println("0.- Salir");
			
			System.out.print("\nElige una opción:");
			opt = sc.nextLine();
			
			System.out.println();
			
			switch(opt) {
				case "1":
					
					break;
				case "2":
					listarVehiculos(vehiculos);
					
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
	
	public static void listarVehiculos(HashMap<String,Vehiculo> lista) {
		String vs;

		for(String v : lista.keySet()) {
			vs = "Modelo: " + v + "\n";

			if(lista.get(v) instanceof Coche) {
				vs += ((Coche) lista.get(v)).mostrarVehiculo();
			}

			if(lista.get(v) instanceof Minibus) {
				vs += ((Minibus) lista.get(v)).mostrarVehiculo();
			}

			System.out.println(vs+ "\n");

		}
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
	
}
