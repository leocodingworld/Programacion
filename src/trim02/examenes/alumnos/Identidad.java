package trim02.examenes.alumnos;

public class Identidad {
	private String nombre;
	private String apellidos;
	private String dni;
	
	public final static char[] LETRAS_DNI = {
		'T','R','W','A','G',
		'M','Y','F','P','D',
		'X','B','N','J','Z',
		'S','Q','V','H','L',
		'C','K','E'
	};

	public Identidad() {
	}

	public Identidad(String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = rellenarDni(dni);
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String mostrarIdentidad() {
		return this.toString();
	}
	
	public static boolean validarDni(String dni) {	
        int dnin ;
        char letra ;
        boolean valido = false;

        if(dni.matches("[0-9]{1,8}[A-Z]")) {
            dnin = Integer.parseInt(dni.substring(0, dni.length() - 1));
            letra = dni.charAt(dni.length() - 1);

            // Si al hacer la division con 23 sale eentre 0y 22 y es igual a letra
            // Devuelve true
            valido = LETRAS_DNI[dnin % 23] == letra;
        }	

        return valido;
}

    
    public static String rellenarDni(String dni) {
        String dnin = dni;
        
        for(int i = dni.length(); i < 9; i++) {
            dnin = "0" + dnin;
        }
        
        return dnin;
    }
	
	@Override
	public String toString() {
		return "\tDNI: " + this.dni +
			"\n\tNombre: " + this.nombre +
			"\n\tApellidos: " + this.apellidos;
	}
		
}
