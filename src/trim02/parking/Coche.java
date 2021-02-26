package trim02.parking;

public class Coche extends Vehiculo {
	private float longitud;

	public Coche (Conductor conductor, String matricula, float longitud) {
		super(conductor, matricula);
		this.longitud = longitud;
	}
	


	@Override
	public float calcularTarifa() {
		int incremento = 0;
		
		return super.calcularTarifa() + incremento;
	}
	
	
}
