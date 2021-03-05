package trim02.parking;

public class Minibus extends Vehiculo {
	private int plazas;

	public Minibus() {}
	
	public Minibus(String matricula, int plazas) {
		super(matricula);
		this.plazas = plazas;
	}
	
	public Minibus(Conductor conductor, String matricula, int plazas) {
		super(conductor, matricula);
		this.plazas = plazas;
	}
	
	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	@Override
	public String mostrarVehiculo() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		return super.toString() + "\tNº Plazas: " + plazas
				+ "\n\tTarifa: " + this.calcularTarifa() + "€";
	}

	@Override
	public int calcularTarifa() {
		return super.calcularTarifa() + (15 * this.plazas);
	}
	
}
