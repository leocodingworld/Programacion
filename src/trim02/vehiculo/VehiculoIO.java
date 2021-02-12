package trim02.vehiculo;

import java.util.Scanner;
import java.util.ArrayList;

public class VehiculoIO {
	
	private static final String MATRICULA_DEF = "AAAA001";
	private static final int NUM_PUERTAS = 4;
	private static final int FACTOR_COCHE = 3;
	private static final int CILINDROS = 6;
	
	public static boolean validarMatricula(String matricula) {
		return matricula.matches("[A-Z]{4}[0-9]{3}");
	}
	
	public static boolean validarFactor(int factor) {
		return factor >= 1 && factor <= 5;
	}
	
	public static boolean validarPuertas(int puertas) {
		return puertas >= 2 && puertas <= 5;
	}

	public static Vehiculo crear(Vehiculo vuser){
		Scanner sc = new Scanner(System.in);
		int opt = 0;

		System.out.print("Puedes escoger entre un coche (1) o una moto (2): ");

		do {
			opt = sc.nextInt();

			if(opt == 1){
				vuser = (Coche) vuser;
				
				vuser.setMatricula(MATRICULA_DEF);
				((Coche) vuser).setNumPuertas(NUM_PUERTAS);
				((Coche) vuser).setFactorPot(FACTOR_COCHE);
			} else if (opt == 2){
				vuser = (Moto) vuser;
				
				vuser.setMatricula(MATRICULA_DEF);
				((Moto) vuser).setCilidrada(CILINDROS);
			} else {
				System.out.print("No es válido, escoge de nuevo:");
			}

		} while(opt < 1 || opt > 2);

		return vuser;
	}

	public static Vehiculo escoger(Vehiculo vuser){
		Scanner sc = new Scanner(System.in);
		int opt = 0;

		ArrayList<Moto> motos = new ArrayList<Moto>(){{
			add(new Moto("ZSAQ019",5));
			add(new Moto("RMNX923",2));
			add(new Moto("FKOD546",3));
		}};

		ArrayList<Coche> coches = new ArrayList<Coche>(){{
			add(new Coche("DTYL741",3,3));
			add(new Coche("DTYL741",2,5));
			add(new Coche("DTYL741",4,2));
		}};

		return vuser;
	}

	public static Vehiculo cambiar(Vehiculo vuser){
		Scanner sc = new Scanner(System.in);
		int opt = 0;

		return vuser;
	}	
	
	public static void menu(){
		Scanner sc = new Scanner(System.in);
		Vehiculo user = new Vehiculo();

		int opt = 0;

		do {

			System.out.println("1.- Crear un nuevo vehículo");
			System.out.println("2.- Escoger un vehiculo");
			System.out.println("3.- Ver ficha técnica del vehículo");
			System.out.println("4.- Cambiar de vehículo");
			System.out.println("5.- Salir");			

			System.out.print("Escoge una opción: ");
			opt = sc.nextInt();

			switch(opt){
				case 1:
					user = crear(user);

					break;
				case 2:
					user = escoger(user);
					break;
				case 3:
					System.out.println(user.verFicha());
					break;
				case 4:
					user = cambiar(user);
					break;
				case 5:
					System.out.println("Gracias por usar nuestro sistema");
					break;
				default:
					break;
			}

		} while (opt != 5);

	}
		
}
