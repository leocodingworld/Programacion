package trim02.vehiculo;

public class Moto extends Vehiculo {
	
	private int cilindrada;
	private int factorPot;
	
	public Moto() {}
	
	public Moto(String matricula, int cilindrada) {
		super(matricula);
		this.cilindrada = cilindrada;
		this.factorPot = setFactorPot(cilindrada);
	}

	public Moto(String matricula, String conductor, int cilindrada) {
		super(matricula, conductor);
		this.cilindrada = cilindrada;
		this.factorPot = setFactorPot(cilindrada);
	}

	public int getCilidrada() {
		return cilindrada;
	}

	public void setCilidrada(int cilidrada) {
		this.cilindrada = cilidrada;
		this.factorPot = setFactorPot(cilidrada);
	}

	public int getFactorPot() {
		return factorPot;
	}
	
	private static int setFactorPot(int cilindros){
		int pot = 0;
		
		if(cilindros < 250) {
			pot = 1;
		} else if(cilindros >= 250 && cilindros < 750) {
			pot = 2;
		} else {
			pot = 3;
		}
		
		return pot;
	}

	@Override
	public String verFicha() {
		return super.verFicha() + "\n" +
				"\tCilindrada: " + this.cilindrada + "\n" +
				"\tFactor de Potencia: " + this.factorPot; 
	}

	@Override
	public float calcularCuota() {
		return super.calcularCuota()+ (0.04f * this.factorPot); 
	}
	
	
}

