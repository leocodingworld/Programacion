package otros;

import java.util.Scanner;

public class Calculadora {
	
	// Método que revisa si la cadena introducida es un número
	public static boolean esNumero(String n) {
		boolean esNum = false; // Se define como falso por defecto
		
		// el método "matches" da verdadero si
		// Coincide exactamente con la expresion regular que se le indica, es decir si solo hay número de n digitos
		// Si se le introduce cualquier otra cosa que no sea un numero, dará falso
		if(n.matches("[0-9]*")) {  
			esNum = true;
		}
		
		return esNum;		
	}

	public static boolean esOperador(String entrada){
		boolean esOperador = false;

		switch(entrada){
			case "+":
			case "-":
			case "*":
			case "/":
				esOperador = true;
				break;
		}

		return esOperador;
	}

	// Método que transforma toda cadena a números
	public static int aEntero(String n) {
		int numero = 0; // el numero de salida
		char digito; // cada "caracter" de la cadena "n"
		int clave; // el codigo que tiene el caracter en la tabla ASCII
		
		for(int i = 0; i < n.length(); i++) {
			digito = n.charAt(i); // Se coge cada caracter de la cadena
			clave = (int) digito; // Se pasa su valor a la cadena ASCII
			clave -= 48; // El valor de la tabla ASCII del 0 empieza en 48
			
			numero = (numero  * (int) Math.pow(10, 1)) + clave; // finalmente se va sumando cada digito anteriormente multiplicado por 10
		}
		
		return numero;
	}

	// Método que simplifica las operaciones matemáticas de una calculadora
	// Devuelve float por las divisiones que no dan numeros enteros
	// Tales como 4/5, 9/2, etc.
	public static float operaciones(int a, int b, String operador) {
		float resultado = 0.0f;
		
		// El operador puede ser: suma, resta, producto y división
		switch(operador) {
			case "+":
				resultado = a + b;
				break;
			case "-":
				resultado = a - b;
				break;
			case "*":
				resultado = a * b;
				break;
			case "/":
				resultado = (float) a / b;
				break;		
		}
		
		return resultado;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada = "";
		String operador = "";
		int op1 = 0;
		int op2 = 0;
		float resultado = 0.0f;
		byte contador = 0;

		System.out.println("Calculadora Estándar 1.0.0");
		System.out.println("Si quieres parar, solo introducir un \"=\"");
		
		do{

			switch(contador){
				case 0:
					System.out.print("Introduce el primer operando: ");
					entrada = sc.next();

					if (!esNumero(entrada)){
						System.out.println("No es válido. Debes introducir un número");
					} else if (esOperador(entrada)) {
						System.out.println("No es válido. Debes introducir un número");
					}

					if (esNumero(entrada)) {
						op1 = aEntero(entrada);
						contador++;
					}

					break;

				case 1:
					System.out.print("Introduce el operador: ");
					entrada = sc.next();

					if (!esOperador(entrada)){
						System.out.println("No es válido. Debes introducir un operador");
					} else if (esNumero(entrada)) {
						System.out.println("No es válido. Debes introducir un operador");
					}

					if (esOperador(entrada)) {
						operador = entrada;
						contador++;
					}

					break;

				case 2:
					System.out.print("Introduce el siguiente operando: ");
					entrada = sc.next();

					if (!esNumero(entrada)){
						System.out.println("No es válido. Debes introducir un número");
					} else if (esOperador(entrada)) {
						System.out.println("No es válido. Debes introducir un número");
					}

					if (esNumero(entrada)) {
						op2 = aEntero(entrada);
						
						resultado = operaciones(op1,op2,operador);
						System.out.println(resultado);
						op1 = (int) resultado;

						contador = 1;
					}

					break;
			}


		} while(!entrada.matches("="));
		
	}

}
