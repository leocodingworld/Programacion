package trim02.banco;

import java.util.Scanner;

public class Banco {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cliente c1 = new Cliente();
		
		int opt = 0;
		String campo;
		String pin;
		String clave;
		
		do{
			System.out.println("1.- Introducir datos del cliente");
			System.out.println("2.- Mostrar datos del cliente");
			System.out.println("3.- Mostrar datos del cliente (Privado)");
			System.out.println("4.- Comprobar clave");
			System.out.println("0.- SALIR");
			System.out.print("Escoge una opción: ");
			opt = Integer.parseInt(sc.next());
			
			switch(opt){
				case 1:
					
					do{
						System.out.print("Introduce el nombre: ");
						campo = sc.next();

						if(!Cliente.validarNombre(campo)){
							System.out.println("El dato introducido no es válido. Vuelve a  introducirlo");
						}

					} while(!Cliente.validarNombre(campo));
					
					c1.setNombre(campo);

					do{
						System.out.print("Introduce el alias: ");
						campo = sc.next();

						if(!Cliente.validarAlias(campo)){
							System.out.println("El dato introducido no es válido. Vuelve a  introducirlo");
						}

					} while(!Cliente.validarAlias(campo));

					c1.setAlias(campo);					
					
					do{
						System.out.print("Introduce la fecha de nacimiento: ");
						campo = sc.next();

						if(!Cliente.validarFecha(campo)){
							System.out.println("El dato introducido no es válido. Vuelve a  introducirlo");
						}

					} while(!Cliente.validarFecha(campo));
					
					c1.setAnhoNac(campo);
					c1.setClave();
					
					System.out.println("¡Datos guardadados!");
					
					break;
				case 2:
					System.out.println(c1.toString());
					
					break;
				case 3:
					System.out.print("Introduce el PIN: ");
					pin = sc.next();
					
					System.out.println(c1.toString(pin));
					break;
				case 4:
					System.out.print("Introducir clave: ");
					clave = sc.next();
					
					if(clave.equals(c1.getClave())){
						System.out.println("Bienvenido.");
					} else {
						System.out.println("Código Erróneo.");
					}
					
					break;
				case 0:
					System.out.println("Hasta luego");
					break;
				default:
					System.out.println("Opción no válida");
					break;
			}
			
			System.out.println("");

		} while(opt != 0);
		
	}
	
}

