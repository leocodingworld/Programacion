 package trim02.vehiculo;

import java.util.Scanner;
//import java.util.ArrayList;

public class VehiculoIO {

	// 1.- Constantes con datos correctos por defectos al crear el vehículo
	private static final String MATRICULA = "0001AAA";
	private static final String CONDUCTOR = "Usuario1";
	private static final int NUM_PUERTAS = 4;
	private static final int FACTOR_COCHE = 3;
	private static final int CILINDROS = 6;

	/* 2.- Métodos
	 *
	 * void menu()
	 * 	 Saca por pantalla el menú con las opciones para:
	 * 	 Crear, cambiar datos, ver la ficha técnica y el cálculo de la couta
	 * 
	 */ 
	public static void menu() {
		// Se instancia un Escaner para recoger datos por pantalla
		Scanner sc = new Scanner(System.in);
		// También un Vehículo que será el de usuario
		Vehiculo user = new Vehiculo();

		int opt = 0;

		do {

			// Se pregunta al usuario las siguientes opciones			
			System.out.println("1.- Escoger un vehículo");
			System.out.println("2.- Cambiar datos del vehículo");
			System.out.println("3.- Ver ficha técnica del vehículo");
			System.out.println("4.- Calcular la cuota del vehículo");
			System.out.println("0.- Salir\n");			

			System.out.print("Escoge una opción: ");
			opt = sc.nextInt();

			switch(opt){
				case 1:
					user = crear();

					break;
				case 2:
					user = cambiarDatos(user);

					break;
				case 3:
					verFicha(user);
					
					break;
				case 4:				
					calcularCuota(user);
					
					break;
				case 0:
					System.out.println("Gracias por usar nuestro sistema");

					break;
				default:
					System.out.println("Opción no válida.");

					break;
			}
			
			System.out.println("\n");

		} while (opt != 0);

	}

	public static Vehiculo crear() {

		Scanner sc = new Scanner(System.in);
		Vehiculo escogido = new Vehiculo();
		int v = 0;

		do {
			System.out.print("¿Quieres un Coche(1) o una Moto(2)? ");
			v = sc.nextInt();

			if(v != 1 && v != 2){
				System.out.println("Opción no válida.");
			}

		} while(v != 1 && v != 2);

		if(v == 1) {
			escogido = new Coche(MATRICULA, CONDUCTOR, NUM_PUERTAS, FACTOR_COCHE);
		} else {
			escogido = new Moto(MATRICULA, CONDUCTOR, CILINDROS);
		}

		System.out.println("Se ha creado correctamente");

		return escogido;

	}

	public static Vehiculo cambiarDatos(Vehiculo vuser){

		Scanner sc = new Scanner(System.in);
		Vehiculo cambiado = vuser;

		String opt = "";
		String dato = "";

		do {

			System.out.println("1.- Cambiar matricula");
			
			if(cambiado instanceof Coche){
				System.out.println("2.- Cambiar Número de puertas");
				System.out.println("3.- Cambiar Factor de Potencia");
			} else {
				System.out.println("2.- Cambiar Cilindrada");
			}

			System.out.println("0.- Menú principal");

			System.out.print("Escoge una opción: ");
			opt = sc.next();

			switch(opt) {

				case "1":
					do {
						System.out.print("Introduce la nueva matrícula (Ejemplo: 1457AFB): ");
						dato = sc.next();

						if(!validarMatricula(dato)){
							System.out.println("Formato no válido.");
						}

					} while (!validarMatricula(dato));

					cambiado.setMatricula(dato);

					System.out.println("Cambio realizado correctamente\n");

					break;

				case "2":

					if(cambiado instanceof Coche) {
						
						do {
							System.out.print("Introduce el número de puertas que quieras (entre 2 y 5): ");
							dato = sc.next();

							if(!validarPuertas(Integer.parseInt(dato))){
								System.out.println("Número fuera de los límites.");
							}
						} while (!validarPuertas(Integer.parseInt(dato)));
						
						((Coche) cambiado).setNumPuertas(Integer.parseInt(dato));

					}

					if(cambiado instanceof Moto) {
						System.out.print("Introduce el número de cilindros: ");

						((Moto)cambiado).setCilidrada(Integer.parseInt(sc.next()));

						System.out.println("Cambio realizado correctamente\n");
					}

					break;

				case "0":
					break;

				default:
					if(cambiado instanceof Coche){

						do {
							System.out.print("Introduce la potencia del coche (Entre 1 y 5): ");
							dato = sc.next();

							if(!validarFactor(Integer.parseInt(dato))){
								System.out.println("Número fuera de los límites.");
							}
						} while (!validarFactor(Integer.parseInt(dato)));

						((Coche) cambiado).setFactorPot(Integer.parseInt(dato));

						break;
					}

					break;
			}

		} while (!opt.equals("0"));

		return cambiado;

	}

	public static void verFicha(Vehiculo vuser){

		if(vuser instanceof Coche){
			System.out.println(((Coche) vuser).verFicha());
		} else {
			System.out.println(((Moto) vuser).verFicha());
		}

	}
	
	public static void calcularCuota(Vehiculo vuser) {
		if(vuser instanceof Coche){
			System.out.println(((Coche) vuser).calcularCuota());
		} else {
			System.out.println(((Moto) vuser).calcularCuota());
		}
	}

	/*public static Vehiculo cambiarVehiculo(Vehiculo vuser) {
		Vehiculo nuevo = new Vehiculo();

		if(vuser instanceof Coche){
			nuevo = new Moto(MATRICULA, CONDUCTOR, CILINDROS);
		}

		if(vuser instanceof Moto){
			nuevo =  new Coche(MATRICULA, CONDUCTOR, NUM_PUERTAS, FACTOR_COCHE);
		}

		return nuevo;
	}

	
	 * public static Vehiculo selectVehiculo(){ Vehiculo selected = new Vehiculo();
	 * 
	 * 
	 * ArrayList<Coche> listaCoche = new ArrayList<Coche>(){{ add(new
	 * Coche("7502SWE",4,5)); add(new Coche("9730ZXP",2,4)); add(new
	 * Coche("5831KTE",3,3)); }};
	 * 
	 * ArrayList<Moto> listaMoto = new ArrayList<Moto>(){{ add(new
	 * Moto("1266FER",125)); add(new Moto("4201AUJ",900)); add(new
	 * Moto("3561JSP",650)); }};
	 * 
	 * do {} while
	 * 
	 * selected.setConductor(CONDUCTOR);
	 * 
	 * return selected; }
	 */

	// 3.- Métodos validadores
	public static boolean validarMatricula(String matricula) {
		return matricula.matches("[0-9]{4}[A-Z]{3}");
	}
	
	public static boolean validarFactor(int factor) {
		return factor >= 1 && factor <= 5;
	}
	
	public static boolean validarPuertas(int puertas) {
		return puertas >= 2 && puertas <= 5;
	}
	
}
