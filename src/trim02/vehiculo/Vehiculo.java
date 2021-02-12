package trim02.vehiculo;

public class Vehiculo {
	
	private String matricula;
	private String conductor;
	
	public Vehiculo() {}
	
	public Vehiculo(String matricula) {
		this.matricula = matricula;
	}


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getConductor() {
		return conductor;
	}

	public void setConductor(String conductor) {
		this.conductor = conductor;
	}
		
	public float calcularCuota() {
		return 250.0f;
	}
	
	public String verFicha() {
		return "Vehículo:\n" +
				"\tMatricula: " + this.matricula +
				"\tConductor: " + this.conductor;
	}

}