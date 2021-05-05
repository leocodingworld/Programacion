package trim02.pruebas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prueba {
	
	private static final String FICHERO_USER = "primos.txt";
	private static final String ERRLOG = "error.txt";
		 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> primos = new ArrayList<Integer>();		
		
		System.out.print("Introduce cuántos primos quieres: ");
		
		int limite = sc.nextInt();		
		boolean noprimo = false;
		
		revisarFicheros();
		
		leerFichero(primos);
		
		int num = 0;
		
		if(primos.size() != 0) {
			num = primos.size() - 1;
		}
			
		while (primos.size() < limite) {
			
			switch(num) {
				case 2:
					num++;
					
					break;
				default:
					num += 2;
					
					break;
			}
			
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
		File fprimos = new File(FICHERO_USER);
		FileWriter escritor = null;
				
		try {
			fprimos.createNewFile();
			escritor = new FileWriter(fprimos);
			
			for (int i : primos) {
				escritor.append(i + "\r\n");
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
