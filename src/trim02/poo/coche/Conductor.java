package trim02.poo.coche;

import java.util.Scanner;

public class Conductor {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Coche ford = new Coche("Ford","Fiesta","0001AAA",150);
		
		int velocidad = 0;
		int opt = 0;
		final int LIMITE = 120;
		
		do{
			System.out.println("1.- Acelerar");
			System.out.println("2.- Acelerar variado");
			System.out.println("3.- Frenar");
			System.out.println("4.- Frenar variado");
			System.out.println("5.- Verificar coche");
			System.out.println("6.- Parar");
			System.out.print("Elije una opción: ");
			opt = sc.nextInt();
			
			switch(opt){
				case 1:
					System.out.println("Acelerando...");
					ford.acelerar();
					
					break;
				case 2:
					System.out.print("Indica la velocidad: ");
					velocidad = sc.nextInt();					
					
					if(ford.getVelocidadActual() + velocidad > ford.getVelocidadMax()){
						System.out.println("El coche no puede ir a más de " + ford.getVelocidadMax() + "Km/h");
						System.out.println("La velocidad de dejará al máximo");												
					}
					
					ford.acelerar(velocidad);
					break;
				case 3:
					System.out.println("Frenando...");
					ford.frenar();
					
					break;
				case 4:
					System.out.print("Indica la velocidad: ");
					velocidad = sc.nextInt();
					
					if(ford.getVelocidadActual() - velocidad < 0){
						System.out.println("El coche se ha frenando totalmente");
					}
					
					ford.frenar(velocidad);
					break;
				case 5:
					System.out.println(ford.toString());
					break;
				case 6:
					System.out.println("Apagando motor...");
					break;
				default:
					System.out.println("Opción no válida");
					break;
			}
			
			if(ford.getVelocidadActual() > LIMITE && opt < 5){
				System.out.println("Aviso: No se puede ir a más de " + LIMITE + "Km/h");
			}
			
			System.out.println("\n");
			
		} while(opt != 5);
		
	}
	
}

