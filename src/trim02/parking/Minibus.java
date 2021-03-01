package trim02.parking;

public class Minibus extends Vehiculo {
	private int plazas;
	
	public Minibus(String matricula, int plazas) {
		super(matricula);
		this.plazas = plazas;
	}
	
	public Minibus(Conductor conductor, String matricula, int plazas) {
		super(conductor, matricula);
		this.plazas = plazas;
	}
	
	public String mostrarVehiculo() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		return super.toString() + "\tNº Plazas: " + plazas
				+ "\n\tTarifa: " + this.calcularTarifa();
	}

	@Override
	public int calcularTarifa() {
		return super.calcularTarifa() + (15 * this.plazas);
	}
	
}
