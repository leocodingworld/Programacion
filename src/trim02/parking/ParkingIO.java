package trim02.parking;

import java.util.Scanner;
import java.util.ArrayList;

public class ParkingIO {	
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		final Conductor user = crearConductor();

		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		
		String opt;
				
		do {
			System.out.println("1.- Añadir un vehíulo");
			System.out.println("2.- Sacar el listado");
			System.out.println("3.- Eliminar vehiculo");
			System.out.println("0.- Salir");
			
			System.out.print("\nElige una opción: ");
			opt = sc.nextLine();
			
			System.out.println();
			
			switch(opt) {
				case "1":
					addVehiculo(vehiculos,user);
					
					break;
				case "2":
					if(vehiculos.isEmpty()) {
						System.out.println("No existen datos para mostrar");
					} else {
						listarVehiculos(vehiculos);
					}
					
					break;
				case "3":
					if(vehiculos.isEmpty()) {
						System.out.println("No existen datos para eliminar");
					} else {
						eliminarVehiculo(vehiculos);
					}				

					break;
				case "0":
					System.out.println("Hasta luego");

					break;
				default:
					System.out.println("Opción no válida");

					break;
			}
			
			System.out.println();
			
		} while(!opt.equals("0"));
		
	}
	
	public static Conductor crearConductor() {		
		Scanner sc = new Scanner(System.in);
		Conductor nuevo;
				
		String nombre;
		String apellidos;
		String telefono;
		
		System.out.println("Para usar el sistema, debe registrarse antes.");
		
		System.out.print("Introduce tu nombre: ");
		nombre = sc.nextLine();
		
		System.out.print("Introduce tus apellidos: ");
		apellidos = sc.nextLine();
		
		do {
			System.out.print("Introduce tu número de teléfono sin espacios (Válido móvil (6- o 7-) o Fijo (9-)):");
			telefono = sc.next();
			
			if(!validarTelefono(telefono)) {
				System.out.println("Formato no válido");
			}
			
		} while(!validarTelefono(telefono));
		
		System.out.println("Se ha registrado con éxito\n\n");
		
		nuevo = new Conductor(nombre, apellidos, telefono);
		
		return nuevo;
	}

	public static void addVehiculo(ArrayList<Vehiculo> lista, Conductor user) {
		Scanner sc = new Scanner(System.in);
		Vehiculo nuevo = new Coche();

		String vopt;
		String matricula;
		float longitud;
		int plazas;
		
		do {
			System.out.print("¿Quiere un Coche(1) o un Minibus(2)?: ");
			vopt = sc.next();
			
			if(!vopt.matches("[12]")) {
				System.out.println("Opción no válida");
			}			
			
		} while(!vopt.matches("[12]"));

		matricula = darMatriculaValida();
				
		switch(vopt){
			case "1":
				longitud = darLongitudValida();

				nuevo = new Coche(user, matricula, longitud);
				
				break;
			case "2":
				plazas = darPlazasValidas();

				nuevo = new Minibus(user, matricula, plazas);
				break;
		}

		System.out.println("Creado con éxito!");
		
		lista.add(nuevo);
	}
	
	public static void listarVehiculos(ArrayList<Vehiculo> lista) {
		for(Vehiculo v : lista) {
			System.out.println(v.mostrarVehiculo());
			System.out.println();
		}		
	}

	public static void eliminarVehiculo(ArrayList<Vehiculo> lista) {
		Scanner sc = new Scanner(System.in);
		Vehiculo eliminado = new Coche();
		String dato;

		System.out.println("Estos son los vehículos actuales:");

		for(Vehiculo m : lista) {
			System.out.println("\t" + m.getMatricula());
		}

		do {
			System.out.print("Indica la matricula del vehículos quieres eliminar: ");
			
			dato = sc.next();
			eliminado.setMatricula(dato);

			if(!lista.contains(eliminado)){
				System.out.println("No existe o se ha introducido mal.");
			}

		} while (!lista.contains(eliminado));
		
		System.out.println("Vehiculo eliminado");
		lista.remove(eliminado);

	}
	
	public static String darMatriculaValida() {
		Scanner sc = new Scanner(System.in);
		String valido = "";
		
		do {
			System.out.print("Introduzca una matrícula (Ejemplo: 1111-BBB): ");
			valido = sc.next();
			
			if(!validarMatricula(valido)) {
				System.out.println("Formato inválido");
			}			
			
		} while(!validarMatricula(valido));
		
		return valido;
	}
	
	public static float darLongitudValida() {
		Scanner sc = new Scanner(System.in);
		String dato = "";
		float valido = 0;
		
		do {
			System.out.print("Introduzca la longitud deseada (se permiten decimales, disponible entre 2,5 y 6): ");
			dato = sc.next().replace(",",".");
			
			if(dato.matches("([0-9]{1,}|[0-9]{1,}[.][0-9]{1,})")) {
				valido = Float.parseFloat(dato); //6.0
			}
			
			if(!validarLongitud(valido)) {
				System.out.println("Fuera de los límites o número invalido.");
			}

		} while(!validarLongitud(valido));
		
		return valido;
		
	}
	
	public static int darPlazasValidas() {
		Scanner sc = new Scanner(System.in);
		String dato;
		int valido = 0;
		
		do {
			System.out.print("Introduzca el número de plazas deseada (Disponible entre 5 y 25): ");
			dato = sc.next().replaceAll("[,.]"," ");
			
			if(dato.matches("[0-9]{1,}")) {
				valido = Integer.parseInt(dato);
			}
			
			if(!validarPlazas(valido)) {
				System.out.println("Fuera de los límites o número invalido.");
			}			

		} while(!validarPlazas(valido));
		
		return valido;
	}
			
	public static boolean validarTelefono(String telefono) {
		return telefono.matches("[679][0-9]{8}"); // (6|7|9)[0-9]{8}
	}
	
	public static boolean validarMatricula(String matricula) {
		return matricula.matches("[0-9]{4}-[B-DF-HJ-NP-TV-Z]{3}");
	}
	
	public static boolean validarLongitud(float longitud) {
		return longitud >= 2.5f && longitud <= 6.0f;
	}
	
	public static boolean validarPlazas(int puertas) {
		return puertas >= 5 && puertas <= 25;
	}	
	
}
