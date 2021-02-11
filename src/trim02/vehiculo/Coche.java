package trim02.vehiculo;

public class Coche extends Vehiculo{
	
	private int numPuertas;
	private int factorPot;
	
	public Coche() {}

	public Coche(String matricula, String conductor, int numPuertas, int factorPot) {
		super(matricula, conductor);
		this.numPuertas = numPuertas;
		this.factorPot = factorPot;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public int getFactorPot() {
		return factorPot;
	}

	public void setFactorPot(int factorPot) {
		this.factorPot = factorPot;
	}
	
	@Override
	public String verFicha(){
		return super.verFicha() + "\n" +
				"\tNúmero de Puertas: " + this.numPuertas + 
				"\tFactor de Potencia: " + this.factorPot;
	}
	
	@Override
	public float calcularCuota(){
		return super.calcularCuota() + (0.05f * this.factorPot);
	}
	
}

