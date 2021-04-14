package trim02.examenes.alumnos;

public class Estudiante extends Alumno {
	private int curso;

	public Estudiante() {
	}

	public Estudiante(String codigoAlumno) {
		super(codigoAlumno);
	}
	
	public Estudiante(Identidad identidad, String codigoAlumno, int curso) {
		super(identidad, codigoAlumno);
		this.curso = curso;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}
	
	public static boolean validarCursos(int cursos) {
		return cursos >= 1 && cursos <= 4;
	}

	@Override
	public String mostrarAlumno() {
		return super.mostrarAlumno() + 
				"\n\tTipo alumno: Estudiante" +
				"\n\tCurso Actual: " + this.curso +
				"\n\tTasas: " + this.calcularTasas() + "€";
	}

	@Override
	public int calcularTasas() {
		int incremento = 0;
		
		switch(this.curso){
			case 1:
				incremento = 250;
				
				break;
			case 2:
				incremento = 500;
				
				break;
			case 3:
				incremento = 750;
				
				break;
			case 4:
				incremento = 1000;
				
				break;
		}
		
		return super.calcularTasas() + incremento; 
	}
		
}
