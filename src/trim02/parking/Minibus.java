package trim02.parking;

public class Minibus extends Vehiculo {
	private int plazas;
	
	public Minibus(Conductor conductor, String matricula, int plazas) {
		super(conductor, matricula);
		this.plazas = plazas;
	}

	@Override
	public float calcularTarifa() {
		return super.calcularTarifa() + (15 * this.plazas);
	}
	
}
