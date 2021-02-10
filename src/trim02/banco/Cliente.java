package trim02.banco;

public class Cliente {
	
	// Definicion de los atributos de la clase
	private String nombre;
	private String cadena;
	private String anhoNac;
	private String clave;
	
	// Constante para pedir la clave de cada cliente
	private final String CLAVE_SECRETA = "Aa12";

	// Constructores
	// Constructor vacio
	public Cliente() {}

	// Constructor con todos los atributos menos con clave,
	// Que se autogenera con un metodo estático y privado
	public Cliente(String nombre, String alias, String anhoNac) {
		this.nombre = nombre;
		this.cadena = alias;
		this.anhoNac = anhoNac;
		this.clave = generarClave(alias,anhoNac);
	}
	
	// Constructor copia o "Clonador"
	public Cliente(Cliente other){
		this.nombre = other.nombre;
		this.cadena = other.cadena;
		this.anhoNac = other.anhoNac;
		this.clave = other.clave;
	}

	// Getters y Setter de la mayoría de atributos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlias() {
		return cadena;
	}

	public void setAlias(String alias) {
		this.cadena = alias;
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
		this.clave = generarClave(this.cadena,this.anhoNac);
	}
	
	// Metodos de validación
	// El nombre es valido si tiene entre 5 y 25 caracteres
	public static boolean validarNombre(String nombre){
		boolean valido = false;
		
		if(nombre.matches("[a-zA-Z]{5,25}")){
			valido = true;
		}
		
		return valido;
	}
	
	// El alias debe ser 5 caracteres en mayúsculas
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
		String a = invertirCadena(alias);
		String f = invertirCadena(fecha);
		String clave = f + "-" + a;
		
		return clave;
	}
	
	public static String invertirCadena(String cadena) {
		String invertido = "";
		
		for(int i = cadena.length() - 1; i >= 0; i--){
			invertido += cadena.charAt(i);
		}
		
		return invertido;
	}

	@Override
	public String toString() {
		return "Cliente{" + "nombre=" + nombre + ", alias=" + cadena + ", anhoNac=" + anhoNac + '}';
	}
	
	public String toStringPrivado(String clave) {
		if(clave.equals(CLAVE_SECRETA)){
			return "Cliente{" + "nombre=" + nombre + ", alias=" + cadena + ", anhoNac=" + anhoNac + ", clave=" + this.clave + '}';
		} else {
			System.out.println("Acceso denegado");
			return this.toString();
		}
		
	}
	
}
