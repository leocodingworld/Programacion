package trim02.poo.coche;

import java.util.Objects;

public class Coche {

	private String marca;
	private String modelo;
	private String matricula;
	private int velocidadActual;
	private int velocidadMax;
	private final int V = 10;
	
	public Coche() {}
	
	public Coche(String marca, String modelo, String matricula, int velocidadMax) {
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.velocidadActual = 0;
		this.velocidadMax = velocidadMax;
	}
	
	// Métodos setter y getter de cada atributo
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getVelocidadActual() {
		return velocidadActual;
	}

	public void setVelocidadActual(int velocidadActual) {
		this.velocidadActual = velocidadActual;
	}

	public int getVelocidadMax() {
		return velocidadMax;
	}

	public void setVelocidadMax(int velocidadMax) {
		this.velocidadMax = velocidadMax;
	}
	
	// Métodos especiales
	// Si la suma de la velocidad del coche supera la máxima
	// Se deja la máxima
	public void acelerar() {
		if(this.velocidadActual + V > this.velocidadMax){
			this.velocidadActual = this.velocidadMax;
		} else {
			this.velocidadActual = this.velocidadActual + V;
		}
	}
	
	public void acelerar(int velocidad) {
		if(this.velocidadActual + velocidad > this.velocidadMax){
			this.velocidadActual = this.velocidadMax;
		} else {
			this.velocidadActual = this.velocidadActual + velocidad;
		}
	}
	
	// Así mismo, un coche no puede tener menos de 0 se deja la velocidad a 0
	public void frenar() {
		if(this.velocidadActual - V < 0){
			this.velocidadActual = 0;
		} else {
			this.velocidadActual = this.velocidadActual - V;
		}
	}
	
	public void frenar(int velocidad) {
		if(this.velocidadActual - velocidad < 0){
			this.velocidadActual = 0;
		} else {
			this.velocidadActual = this.velocidadActual - velocidad;
		}
	}
	
	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + ", velocidadActual="
				+ velocidadActual + ", velocidadMax=" + velocidadMax + "]";
	}

	@Override
	public boolean equals(Object obj) {
		 Coche other = (Coche) obj;
		 
		 return Objects.equals(this.matricula, other.matricula);
	}
		
}

