package trim02.parking;

public abstract class Vehiculo implements Tarifable {
	
	private Conductor conductor;
	private String matricula;
	
			
	public Vehiculo(Conductor conductor, String matricula) {
		this.conductor = conductor;
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
		return super.toString();
	}

}
