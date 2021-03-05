package trim02.parking;

public class Conductor {
	private String nombre;
	private String apellidos;
	private String telefono;
	private String codConductor;
	
	public Conductor() {}

	public Conductor(String nombre, String apellidos, String telefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.codConductor = generarCodigo(nombre, apellidos, telefono);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodConductor() {
		return codConductor;
	}
	
	public String mostrarConductor(){
		return this.toString();
	}

	@Override
	public String toString() {
		return "Conductor:\n" +
			"\t\tNombre: " + nombre + "\n" +
			"\t\tApellidos: " + apellidos + "\n" +
			"\t\tTeléfono: " + telefono + "\n";
	}

	private String generarCodigo(String nombre, String apellidos, String telefono) {
		String n = nombre;
		String a = apellidos;
		
		switch(n.length()){
			case 1:
				n += "XX";

				break;
			case 2:
				n += "X";

				break;
		}

		switch(a.length()){
			case 1:
				a += "XX";

				break;
			case 2:
				a += "X";

				break;
		}
		
		return n.substring(0,2).toUpperCase() + "-" + 
				telefono.substring(2,6) + "-" +
				a.substring(a.length() - 3).toUpperCase();
	}
	
}
