package trim02.banco;

public class Cliente {
	
	private String nombre;
	private String alias;
	private String anhoNac;
	private String clave;
	
	private final String CLAVE_SECRETA = "Aa12";

	public Cliente() {}

	public Cliente(String nombre, String alias, String anhoNac) {
		this.nombre = nombre;
		this.alias = alias;
		this.anhoNac = anhoNac;
		this.clave = generarClave(alias,anhoNac);
	}
	
	public Cliente(Cliente other){
		this.nombre = other.nombre;
		this.alias = other.alias;
		this.anhoNac = other.anhoNac;
		this.clave = other.clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getAnhoNac() {
		return anhoNac;
	}

	public void setAnhoNac(String anhoNac) {
		this.anhoNac = anhoNac;
	}

	public String getClave() {
		return clave;
	}

	public void setClave() {
		this.clave = generarClave(this.alias,this.anhoNac);
	}
	
	public static boolean validarNombre(String nombre){
		boolean valido = false;
		
		if(nombre.matches("[aA-zZ]{5,25}")){
			valido = true;
		}
		
		return valido;
	}
	
	public static boolean validarAlias(String alias){
		boolean valido = false;
		
		if(alias.matches("[A-Z]{5}")){
			valido = true;
		}
		
		return valido;
	}
	
	public static boolean validarFecha(String fecha){
		boolean valido = false;
		int cambio = Integer.parseInt(fecha);
		
		if(cambio < 2000){
			valido = true;
		}
				
		return valido;
	}
	
	private static String generarClave(String alias, String fecha){
		String clave = "";
		String a = "";
		String f = "";
		
		for(int i = alias.length() - 1; i >= 0; i--){
			a += alias.charAt(i);
		}
		
		for(int i = fecha.length() - 1; i >= 0; i--){
			f += fecha.charAt(i);
		}
		
		clave = f + "-" + a;
		
		return clave;
	}

	@Override
	public String toString() {
		return "Cliente{" + "nombre=" + nombre + ", alias=" + alias + ", anhoNac=" + anhoNac + '}';
	}
	
	public String toStringPrivado(String clave) {
		if(clave.equals(CLAVE_SECRETA)){
			return "Cliente{" + "nombre=" + nombre + ", alias=" + alias + ", anhoNac=" + anhoNac + ", clave=" + this.clave + '}';
		} else {
			System.out.println("Acceso denegado");
			return this.toString();
		}
		
	}
}
