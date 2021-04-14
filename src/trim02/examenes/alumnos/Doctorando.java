package trim02.examenes.alumnos;

public class Doctorando extends Alumno{
	private int numCursos;

	public Doctorando() {
	}

	public Doctorando(Identidad identidad, String codigoAlumno, int numCursos) {
		super(identidad, codigoAlumno);
		this.numCursos = numCursos;
	}

	public int getNumCursos() {
		return numCursos;
	}

	public void setNumCursos(int numCursos) {
		this.numCursos = numCursos;
	}
	
	public static boolean validarNumCursos(int numCursos) {
		return numCursos >= 1 && numCursos <= 6;
	}

	@Override
	public String mostrarAlumno() {
		return super.mostrarAlumno() +
				"\n\tTipo Alumno: Doctorando" +
				"\n\tNº de cursos: " + this.numCursos +
				"\n\tTasas: " + this.calcularTasas() + "€"; 
	}

	@Override
	public int calcularTasas() {
		return super.calcularTasas() + (175 * this.numCursos); 
	}
	
}
