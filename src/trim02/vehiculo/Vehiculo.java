package trim02.vehiculo;

public class Vehiculo {
	
	private String matricula;
	private String conductor;
	
	public float calcularCuota() {
		return 250.0f;
	}
	
	public String verFicha() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", conductor=" + conductor + "]";
	}
	
}
