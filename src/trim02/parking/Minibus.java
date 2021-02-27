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
	
	@Override
	public String toString() {
		return super.toString() + "Nº Plazas: " + plazas;
	}

	@Override
	public int calcularTarifa() {
		return super.calcularTarifa() + (15 * this.plazas);
	}
	
}
