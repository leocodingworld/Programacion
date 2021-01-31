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

	public Equipo(String codigo, byte numJugadores) {
		this.codigo = codigo;
		this.valoracion = 0;
		this.numJugadores = 12;
	}

	public Equipo(Equipo other) {
		
	} 
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	public byte getNumJugadores() {
		return numJugadores;
	}

	public void setNumJugadores(byte numJugadores) {
		this.numJugadores = numJugadores;
	}
		
	void aumentarValoracion() {
		this.valoracion = valoracion + 10 + (numJugadores * 0.5f);
	}

	@Override
	public String toString() {
		return "Equipo [codigo=" + codigo + ", valoracion=" + valoracion + ", numJugadores=" + numJugadores + "]";
	}
	
	public static boolean validarCadena(String cadena) {
		boolean valido = false;
		
		if(cadena.length() >= 3 && cadena.length() <= 15) {
			if(cadena.matches("^[A-Z]")) {}
		}
		
		return valido;
		
	}
}
