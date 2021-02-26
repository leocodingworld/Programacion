package trim02.parking;

public abstract class Vehiculo implements Tarifable {
	
	private Conductor conductor;
	private String matricula;
	
	public Vehiculo(String matricula) {
		super();
		this.matricula = matricula;
	}

	public Vehiculo(Conductor conductor, String matricula) {
		this.conductor = conductor;
		this.matricula = matricula;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public float calcularTarifa() {
		return 75.0f;
	}
	
	@Override
	public boolean equals(Object obj) {
		Vehiculo otro = (Vehiculo) obj;
		return this.matricula.equals(otro.matricula);
	}

	@Override
	public String toString() {
		return "Datos del vehículo:\n" + 
				"\tConductor:" + conductor.getNombre() +
				"\tMatricula=" + matricula + "\n";
	}

}
