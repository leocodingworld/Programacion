package trim02.parking;

public class Coche extends Vehiculo {	
	private float longitud;

	public Coche() {}
	
	public Coche (String matricula, float longitud) {
		super(matricula);
		this.longitud = longitud;
	}

	public Coche (Conductor conductor, String matricula, float longitud) {
		super(conductor, matricula);
		this.longitud = longitud;
	}
	
	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	
	public String mostrarVehiculo() {
		return this.toString();
	}

	@Override
	public String toString() {
		return super.toString() + 
				"\tLongitud: " + longitud  +
				"\n\tTarifa: " + this.calcularTarifa() + "€";
	}

	@Override
	public int calcularTarifa() {
		int incremento = 0;
		
		if(this.longitud >= 2.5f && this.longitud < 3.5f) {
			incremento = 50;
		} else if (this.longitud >= 3.5f && this.longitud <= 4.75f) {
			incremento = 75;
		} else {
			incremento = 100;
		}
		
		return super.calcularTarifa() + incremento;
	}
		
}
