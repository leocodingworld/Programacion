package trim02.vehiculo;

public class VehiculoIO {
	
	public static boolean validarMatricula(String matricula) {
		return matricula.matches("[A-Z]{4}[0-9]{3}");
	}
	
	public static boolean validarFactor(int factor) {
		return factor >= 1 && factor <= 5;
	}
	
	public static boolean validarPuertas(int puertas) {
		return puertas >= 2 && puertas <= 5;
	}
	
	public static void initMenu(int opt){
		System.out.println("1.- Crear un nuevo vehículo");
		System.out.println("2.- Escoger un vehículo");
		System.out.println("3.- ");
	}
}
