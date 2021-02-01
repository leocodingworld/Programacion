package trim02.poo.torneo;

import java.util.Scanner;

public class Equipo {

	private String codigo;
	private float valoracion;
	private byte numJugadores;
	
	public Equipo() {
		this.numJugadores = 12;
	}

	public Equipo(String codigo, float valoracion) {
		this.codigo = codigo;
		this.valoracion = valoracion;
		this.numJugadores = 12;
	}

	public Equipo(String codigo) {
		this.codigo = codigo;
		this.valoracion = 0;
		this.numJugadores = 12;
	}

	public Equipo(Equipo other) {
		this.codigo = other.codigo;
		this.valoracion = other.valoracion;
		this.numJugadores = other.numJugadores;
	} 
	
	public String getCodigo() {
		return codigo;
	}

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

	public void setNumJugadores() {
		byte numj = this.pedirNumJugadores();

		if(validarNumJugadores(numj)){
			this.numJugadores = numj;
		}
	}
		
	void aumentarValoracion() {
		this.valoracion = valoracion + 10 + (numJugadores * 0.5f);
	}

	@Override
	public String toString() {
		return "Equipo [codigo=" + codigo + ", valoracion=" + valoracion + ", numJugadores=" + numJugadores + "]";
	}

	public String pedirPatrocinador(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el patrocinador: ");
		String patrocinador = sc.nextLine();

		if(!validarCadena(patrocinador)){
			patrocinador = patrocinador.replaceAll(" ", "");
		}
		
		return patrocinador;
	}
	
	public String pedirCiudad(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce la ciudad: ");
		String ciudad = sc.nextLine();

		if(!validarCadena(ciudad)){
			ciudad = ciudad.replaceAll(" ", "");
		}

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
		System.out.print("Introduce el número de jugadores: ");
		
		byte numj = sc.nextByte();

		return numj;
	}

	public static String generarCodigo(String patrocinador, String ciudad){
		String codigo = patrocinador.substring(0,3) + "-" + ciudad.toUpperCase();

		return codigo;
	}

	public static boolean validarNumJugadores(byte numj){
		return numj > 8 && numj < 12;
	}

	public static boolean validarCadena(String cadena) {
		boolean valido = false;
		
		if(cadena.length() >= 3 && cadena.length() <= 15) {
			if(cadena.matches("^[A-Z]*")) {
				valido = true;
			}
		}
		
		return valido;		
	}	

}
