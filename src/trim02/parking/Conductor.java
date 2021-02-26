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

	private String generarCodigo(String nombre, String apellidos, String telefono) {		
		return nombre.substring(0,4).toUpperCase() + "-" + telefono.substring(2,6);
	}
	
}
