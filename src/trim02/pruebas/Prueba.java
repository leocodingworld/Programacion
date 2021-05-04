package trim02.pruebas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Prueba {
	
	private static final String FICHERO_USER = "primos.txt";
	private static final String ERRLOG = "error.log";
		 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> primos = new ArrayList<Integer>() {{
			add(2);
			add(3);
		}};		
		
		System.out.print("Introduce cuántos primos quieres");
		
		int limite = sc.nextInt();		
		boolean noprimo = false;
		
		revisarFicheros();
		
		leerFichero(primos);
		
		int num = primos.get(primos.size() - 1);
		
		System.out.println("\n\nNúmeros primos anteriores:");
						
		System.out.println("\nNúmeros primos nuevos:");
		
		while (primos.size() < limite) {
			num += 2;
			
			 for (int i = primos.size() - 1; i >= 0 && !noprimo; i--) {
				if(num % primos.get(i) == 0) {
					noprimo = true;
				}
			}
			 
			 if(!noprimo) {
				 primos.add(num);
				 System.out.println(num);
			 }
			 
			 noprimo = false;
		}
		
		escribirFichero(primos);
	}
	
	public static void revisarFicheros() {
		File fprimos = new File(FICHERO_USER);
		
		try {
			fprimos.createNewFile();
		} catch (IOException ioe) {
			escribirLog(ioe.getMessage());
		}
	}
			
	public static void leerFichero(ArrayList<Integer> primos) {
		File fprimos = new File(FICHERO_USER);
		String p = "";
		
		try {
			Scanner fsc = new Scanner(fprimos);
			
			while(fsc.hasNextLine()) {
				if(!(p = fsc.nextLine()).matches("[23]")) {
					primos.add(Integer.parseInt(p));
				}
			}
		} catch (IOException ioe) {
			escribirLog(ioe.getMessage());
		}
		
	}
	
	public static void escribirFichero(ArrayList<Integer> primos) {
		File log = new File(FICHERO_USER);
		FileWriter escritor = null;
				
		try {
			log.createNewFile();
			escritor = new FileWriter(log);
			
			for (int i : primos) {
				escritor.append(String.valueOf(i) + "\r\n");
			}
									
		} catch(IOException ioe) {
			System.out.println("Error al escrbir en el fichero => " + ioe.getMessage());
		} finally {
			try {
				escritor.close();
			} catch (IOException e) {
				System.out.println("Error => " + e.getMessage());
			}
		}
	}
	
	public static void escribirLog(String mensaje) {
		File log = new File(ERRLOG);
		FileWriter escritor = null;
		
		try {
			log.createNewFile();
			escritor = new FileWriter(log);
			
			escritor.write(mensaje);
		} catch(IOException ioe) {
			System.out.println("Error al escrbir en el fichero => " + ioe.getMessage());
		} finally {
			try {
				escritor.close();
			} catch (IOException e) {
				System.out.println("Error => " + e.getMessage());
			}
		}
		
	}
	
}
