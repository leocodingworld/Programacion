package trim02.examenes.alumnos;

import java.util.HashMap;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {//a
		Scanner sc = new Scanner(System.in);
		HashMap<String, Alumno> alumnos = new HashMap<>();
        
		String opt;
		
		do {
			System.out.println("1.- Añadir nuevo Alumno");
			System.out.println("2.- Visualizar listado");
			System.out.println("3.- Elimnar alumno");
			System.out.println("4.- Calcular Ingresos");
			System.out.println("0.- Salir");
			
			System.out.print("Escoge una opción: ");
			opt = sc.next();
			
			switch(opt){
				case "1": 
					anadeAlumno(alumnos);
					
					break;
				case "2":
					visualizarListado(alumnos);
	
					break;
				case "3":
			        if(alumnos.isEmpty()){
			            System.out.println("No existen datos para eliminar");
			        } else {
			            eliminarAlumno(alumnos);
			        }
	
			        break;
				case "4":
					calcularIngresos(alumnos); 
	
					break;
				case "0":
					System.out.println("Hasta luego.");
	
					break;
				default:  
					System.out.println("Opción no válida");
					break;
			}
			
			System.out.print("\n");
			
		} while(!opt.equals("0"));
	}
	
	public static void anadeAlumno(HashMap<String, Alumno> lista) {
	Scanner sc = new Scanner(System.in);
	Identidad identidad;
	Alumno nuevo = new Estudiante();
	
	String opt;
	String dni;
	String nombre;
	String apellidos;
	String codAlumno;
	String dato; 	// Este valor lo uso para pedir tanto el curso del Estudiante como los cursos del Doctorando
	int curso = 0;
	
	
	/**
	 * Indica el tipo de alumno que se desea
	 *	1) Estudiante
	 *	2) Doctorando
	 */
	do {
		System.out.print("Indique el tipo de alumno, ¿Estudiante(1) o Doctorando(2)?: ");
		opt = sc.nextLine();
		
		if(!opt.matches("[12]")) {
			System.out.println("Opción no válida");
		}

	} while(!opt.matches("[12]"));

	/**
	 * Introduce el nombre y apellidos del nuevo alumno
	 */
	System.out.print("Introduce el nombre: ");
	nombre = sc.nextLine();
	
	System.out.print("Introduce el apellidos: ");
	apellidos = sc.nextLine();
	
	System.out.print("Introduce el DNI del alumno (Debe ser valido): ");

	do {
		dni = sc.nextLine().toUpperCase();
		      
        if(!Identidad.validarDni(dni)){
            System.out.println("DNI no valido. Vuelve a introducirlo");
        }
         
    } while (!Identidad.validarDni(dni));
	

	identidad = new Identidad(nombre, apellidos, dni);
	
    System.out.println("Introduce el codigo de alumno (Debe ser 3 numeros seguido de un guion \"-\" y entre 1 y 4 letras): ");
    
	do {
		codAlumno = sc.nextLine();

		if(!Alumno.validarCodigo(codAlumno)){
			System.out.println("Codigo no valido. Vuelve a introducirlo");
		}

		if(lista.containsKey(codAlumno)) {
			System.out.println("Ya existe un alumno matriculado con ese codigo. Introduce uno nuevo");
		}

	} while (!Alumno.validarCodigo(codAlumno) || lista.containsKey(codAlumno));

	switch(opt) {
		case "1":
            System.out.println("Introduce el curso actual (Disponible entre 1Âº y 4Âº)");
            
			do {
				dato = sc.next();

				if(dato.matches("[0-9]{1,}")){
					curso = Integer.parseInt(dato);

					if(!Estudiante.validarCursos(curso)){
						System.out.println("Curso no valido. Vuelve a introducirlo");
					}
				} else {
					System.out.println("Dato no valido. Vuelve a introducirlo");
				}

			} while (!Estudiante.validarCursos(curso));
			
			nuevo = new Estudiante(identidad, codAlumno, curso);
			break;
		case "2":
            System.out.println("Introduce el numero de cursos (Disponible entre 1 y 6)");
            
			do {
				dato = sc.next();

				if(dato.matches("[0-9]{1,}")){
					curso = Integer.parseInt(dato);

					if(!Doctorando.validarNumCursos(curso)){
						System.out.println("Curso no valido. Vuelve a introducirlo");
					}
				} else {
					System.out.println("Dato no valido. Vuelve a introducirlo");
				}

			} while (!Doctorando.validarNumCursos(curso));
			
			nuevo = new Doctorando(identidad, codAlumno, curso);
			break;
	}
	
	System.out.println("Se ha añadido correctamente\n");
	
	lista.put(nuevo.getCodigoAlumno(), nuevo);
}
	
	public static void visualizarListado(HashMap<String, Alumno> lista) {
		if(lista.isEmpty()) {
			System.out.println("No hay datos para mostrar");
		}
		
		for(Alumno a : lista.values()) {
			System.out.println(a.mostrarAlumno());
		}
	}
	
	public static void eliminarAlumno(HashMap<String, Alumno> lista) {
		Scanner sc = new Scanner(System.in);
		String codAlumno;
		
		System.out.println("Estos son los alumnos que están matriculados: ");
		
		for(String a: lista.keySet()) {
			System.out.println("\t" + a);
		}
		
		System.out.println("Indica el codigo del alumno que quieres eliminar: ");
		
		do {			
			codAlumno = sc.next();
		
			if(!lista.containsKey(codAlumno)) {
				System.out.println("No existe ese alumno con ese codigo o está mal escrito");
			}
			
		} while(!lista.containsKey(codAlumno));	
		
		System.out.println("Se ha eliminado el alumno correctamente");
		
		lista.remove(codAlumno);
	}
	
	public static void calcularIngresos(HashMap<String, Alumno> lista) {
		int totalEstudiantes = 0;
		int totalDoctorando = 0;
		int t;

		for(Tasable a : lista.values()) {
			t = a.calcularTasas();
			
			if(a instanceof Estudiante) {
				totalEstudiantes += t;
			}
			
			if(a instanceof Doctorando) {
				totalDoctorando += t;
			}
		}
		
		System.out.println("Ingresos por los estudiantes: " + totalEstudiantes + "€");
		System.out.println("Ingresos por los Doctorando: " + totalDoctorando + "€");
		System.out.println("Ingresos por todos los matriculados: " + (totalEstudiantes + totalDoctorando)+ "€");
	}
}
