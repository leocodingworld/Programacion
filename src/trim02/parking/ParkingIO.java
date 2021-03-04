package trim02.parking;

import java.util.Scanner;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ParkingIO {	
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		final Conductor user = crearConductor();

		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>() {{
			add(new Coche(new Conductor("Maria","Garcia","789456123"),"1038-STP", 2.7f));
			add(new Coche(new Conductor("German","Palomares","91475324"),"0254-YWY", 3.0f));
			add(new Coche(new Conductor("Jean Paul","Delacroix","987341054"),"6669-LXZ", 5.5f));
			
			add(new Minibus(new Conductor("Fulanita","Menganita","748521023"),"8354-SDK", 10));
			add(new Minibus(new Conductor("Francisco","Peres","911582493"),"0173-XCS", 15));
			add(new Minibus(new Conductor("Magdalena","de la Rosa","680314751"),"6503-RSD", 25));
		}};
		
		String opt = "";
				
		do {
			System.out.println("1.- Añadir un vehículo");
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
					listarVehiculos(vehiculos);
					
					break;
				case "3":
					eliminarVehiculo(vehiculos);

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
		Conductor nuevo ;
				
		String nombre = "";
		String apellidos = "";
		String telefono = "";
		
		System.out.println("Para usar el sistema, debe registrarse antes.");
		
		System.out.print("Introduce tu nombre: ");
		nombre = sc.nextLine();
		
		System.out.print("Introduce tus apellidos: ");
		apellidos = sc.nextLine();
		
		do {
			System.out.print("Introduce tu número de telefono sin espacios (Válido móvil (6- o 7-) o Fijo (9-)):");
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
		String dato;
		
		do {
			System.out.print("¿Quiere un Coche(1) o un Minibus(2)?: ");
			vopt = sc.next();
			
			if(!vopt.matches("[12]")) {
				System.out.println("Opción inválida");
			}			
			
		} while(!vopt.matches("[12]"));

		do {
			System.out.print("Introduzca una matricula (Ejemplo: 1111-BBB): ");
			matricula = sc.next();
			
			if(!validarMatricula(matricula)) {
				System.out.println("Formato inválido");
			}			
			
		} while(!validarMatricula(matricula));
				
		switch(vopt){
			case "1":
				do {
					System.out.print("Introduzca la longitud deseada (se permiten decimales, disponible entre 2,5 y 6): ");
					dato = sc.next().replace(",",".");
					
					if(!validarLongitud(Float.parseFloat(dato))) {
						System.out.println("Fuera de los límites.");
					}			
					
				} while(!validarLongitud(Float.parseFloat(dato)));				

				nuevo = new Coche(user, matricula, Float.parseFloat(dato));
				
				break;
			case "2":
				do {
					System.out.print("Introduzca el número de plazas (Disponible entre 5 y 25): ");
					dato = sc.next().replaceAll("[.,]", "");
					
					if(!validarPlazas(Integer.parseInt(dato))) {
						System.out.println("Fuera de los límites o formato de número inválido");
					}			
					
				} while(!validarPlazas(Integer.parseInt(dato)));	

				nuevo = new Minibus(user,matricula,Integer.parseInt(dato));
				break;
		}

		System.out.println("¡Creado con éxito!");		
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
		Vehiculo eliminado = new Minibus();
		String dato;

		System.out.println("Estos son los vehículos actuales:");

		for(Vehiculo m : lista){
			System.out.println("\t" + m.getMatricula());
		}

		do {
			System.out.print("Indica la matricula del vehículo quieres eliminar: ");
			
			dato = sc.next();
			eliminado.setMatricula(dato);

			if(!lista.contains(eliminado)){
				System.out.println("No existe o se ha introducido mal.");
			}

		} while (!lista.contains(eliminado));
		
		System.out.println("Vehiculo eliminado");
		lista.remove(eliminado);

	}
	
	public static boolean validarTelefono(String telefono) {
		return telefono.matches("[679][0-9]{8}");
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
