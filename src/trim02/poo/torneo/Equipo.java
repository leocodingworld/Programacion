package trim02.poo.torneo;

import java.util.Scanner;

public class Equipo {
	
	// Atributos de la clase
	private String codigo;
	private float valoracion;
	private byte numJugadores;
	
	// Constructores, por defecto todos se inicializan con 12 jugadores
	// Constructor vacio
	public Equipo() {
		this.numJugadores = 12;
	}

	// Constructor con codigo y valoracion
	public Equipo(String codigo, float valoracion) {
		this.codigo = codigo;
		this.valoracion = valoracion;
		this.numJugadores = 12;
	}

	// Constructor con codigo y valoracion igual a 0
	public Equipo(String codigo) {
		this.codigo = codigo;
		this.valoracion = 0;
		this.numJugadores = 12;
	}

	// Constructor copia, genera un clon de otro Equipo
	public Equipo(Equipo other) {
		this.codigo = other.codigo;
		this.valoracion = other.valoracion;
		this.numJugadores = other.numJugadores;
	} 

	// Getters y Setters de cada Atributo
	public String getCodigo() {
		return codigo;
	}

	// Cuando se vaya a dar un codigo, pedirá al usuario el patrocinador y la ciudad
	public void setCodigo() {
		String c = generarCodigo(this.pedirPatrocinador(), this.pedirCiudad());
		this.codigo = c;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion() {
		this.valoracion = this.pedirValoracion();
	}

	public byte getNumJugadores() {
		return numJugadores;
	}

	// Se pedirá el numero de jugadores al usuario
	// si no está entre 8 y 12, se dejará 12 por defecto
	public void setNumJugadores() {
		byte numj = this.pedirNumJugadores();

		if(validarNumJugadores(numj)){
			this.numJugadores = numj;
		} else {
			System.out.println("Número de jugadores erróneo. Se dejará por defecto 12");
		}
		
	}
	
	// Este metodo solo es visible por el paquete al que pertenece
	void aumentarValoracion() {
		this.valoracion = valoracion + 10 + (numJugadores * 0.5f);
	}

	@Override
	public String toString() {
		return "Equipo [codigo=" + codigo + ", valoracion=" + valoracion + ", numJugadores=" + numJugadores + "]";
	}

	// metodos para pedir los datos al usuario
	// Ciudad y patrocinador se limpian dejando sin tildes ni espacios
	public String pedirPatrocinador(){
		Scanner sc = new Scanner(System.in);
		String patrocinador;
		System.out.print("Introduce el patrocinador: ");
		
		do {
			patrocinador = sc.next();
			patrocinador = limpiarCadena(patrocinador);
			
			if(!validarCadena(patrocinador)) {
				System.out.print("No es válido, introduce el dato de nuevo: ");
			}
			
		} while (!validarCadena(patrocinador));
		
		return patrocinador;
	}
	
	public String pedirCiudad(){
		Scanner sc = new Scanner(System.in);
		String ciudad = "";
		System.out.print("Introduce la ciudad: ");
		
		do {
			ciudad = sc.next();
			ciudad = limpiarCadena(ciudad);
			
			if(!validarCadena(ciudad)) {
				System.out.print("No es válido, introduce el dato de nuevo: ");
			}
			
		} while (!validarCadena(ciudad));		

		return ciudad;
	}

	public float pedirValoracion(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce la valoracion: ");
		float val = sc.nextFloat();

		return val;
	}

	public byte pedirNumJugadores(){
		Scanner sc = new Scanner(System.in);
		byte numj;
		System.out.print("Introduce el número de jugadores: ");
		
		numj = sc.nextByte();
		
		if(!validarNumJugadores(numj)) {
			numj = 12;
		}

		return numj;
	}

	// Cuandos se tiene el patrocinador y la ciudad, se que genera el codigo del equipo
	public static String generarCodigo(String patrocinador, String ciudad){
		String codigo = patrocinador.substring(0,3) + "-" + ciudad.toUpperCase();

		return codigo;
	}

	public static boolean validarNumJugadores(byte numj){
		return numj > 8 && numj < 12;
	}

	public static boolean validarCadena(String cadena) {
		boolean valido = false;
		
		if(cadena.matches("^[A-Z][a-zA-Z]{2,14}")) {
			valido = true;
		}
				
		return valido;		
	}
	
	public static String limpiarCadena(String cadena) {
		String limpio = cadena.replaceAll("á", "a");
		
		limpio = limpio.replaceAll("é", "e");
		limpio = limpio.replaceAll("í", "i");
		limpio = limpio.replaceAll("ó", "o");
		limpio = limpio.replaceAll("ú", "u");
		limpio = limpio.replaceAll(" ", "");
		
		return limpio;		
	}

}
