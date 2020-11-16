package trim01.BloqueEjercicios4;

import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;

public class Eje07_PPaTLS {
	
	public static String opcion(int opt) {
		String objecto = "";
		
		switch(opt) {
			case 0:
				objecto = "Piedra";
				break;
			case 1:
				objecto = "Papel";
				break;
			case 2:
				objecto = "Piedra";
				break;
			case 3:
				objecto = "Lagarto";
				break;
			case 4:
				objecto = "Spock";
				break;
		}
		
		return objecto;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		HashMap<Integer, String> opcion = new HashMap<Integer,String>();
		opcion.put(0, "Piedra");
		opcion.put(1, "Papel");
		opcion.put(2, "Tijera");
		opcion.put(3, "Lagarto");
		opcion.put(4, "Spcok");
		
		String opUser;
		String opCpu;
		int[][] matrix = {
			{ 0, 1,-1,-1,-1},
			{ 1, 0,-1,-1, 1},
			{-1, 1, 0, 1,-1},
			{-1, 1,-1, 0,-1},
			{-1,-1, 1,-1, 0}
		};

		int optu;
		int optcpu;
		int ganaUser = 0;
		int ganaCpu = 0;
		int empates = 0;
		
		while(ganaUser != 3 && ganaCpu != 3) {
			System.out.println("Piedra: 1");
			System.out.println("Papel: 2");
			System.out.println("Tijera: 3");
			System.out.println("Lagarto: 4");
			System.out.println("Spock: 5");
			
			optu = sc.nextInt() - 1;
			optcpu = r.nextInt(5);
			
			System.out.println("Usuario saca " + opcion.get(optu));
			System.out.println("CPU saca " + opcion.get(optcpu));
			
			switch(matrix[optu][optcpu]) {
				case 0:
					System.out.println("Empate");
					empates++;
					
					break;
				case 1:
					System.out.println("Ganas tú");
					ganaUser++;
					
					break;
				case -1:
					System.out.println("Gana la CPU");
					ganaCpu++;
					
					break;
			}
			
			
			System.out.println("");
			System.out.printf("Empates: %d\tCPU: %d\t Usuario: %d%n",empates,ganaCpu,ganaUser);
		} 
		
		if(ganaUser == 3) {
			System.out.println("¡Has Ganado!");
		} else {
			System.out.println("Te ganó la máquina");
		}

	}
	
}
