package trim02.examenes.alumnos;

import java.util.Objects;

public abstract class Alumno implements Tasable {
    private Identidad identidad;
    private String codigoAlumno;

    public Alumno() {
    }

    public Alumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public Alumno(Identidad identidad, String codigoAlumno) {
        this.identidad = identidad;
        this.codigoAlumno = codigoAlumno;
    }

    public Identidad getIdentidad() {
        return identidad;
    }

    public void setIdentidad(Identidad identidad) {
        this.identidad = identidad;
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
    	this.codigoAlumno = codigoAlumno;
    }

	public static boolean validarCodigo(String codigo) { 
		return codigo.matches("[0-9]{3}-[a-zA-Z]{1,4}");
	}
	
    @Override
    public int calcularTasas() {
		return 350;
    }

    public String mostrarAlumno() {
		return this.toString();
    }

    @Override
    public String toString() {
        return "Alumno:\n" + this.identidad.mostrarIdentidad() + 
                "\n\tCodigo de Alumno: " + this.codigoAlumno;
    }

    @Override
    public boolean equals(Object obj) {
        final Alumno other = (Alumno) obj;
        return Objects.equals(this.codigoAlumno, other.codigoAlumno);
    }
               
}
