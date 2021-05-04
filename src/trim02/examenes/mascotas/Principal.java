package trim02.examenes.mascotas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {

    public static final String FICHERO = "mascotas.info";

    public static void main(String[] args) {
        File fmascotas = new File(FICHERO);

        try {
            // Crea el archivo si no existe
            // en caso contrario, no hace nada y sigue el porgrama normal
            fmascotas.createNewFile();
        } catch (IOException ioe) {
            // No hace nada
            // Puede que no tenga permisos para leerlo y salte este error
        } 
        
        Scanner sc = new Scanner(System.in);
        HashMap<String, Mascota> mascotas = new HashMap<>();
        String opt;

        cargarDatos(mascotas);

        do {
            System.out.println("1.- Añadir nueva Mascota");
            System.out.println("2.- Visualizar listado");
            System.out.println("3.- Elimnar Mascota");
            System.out.println("4.- Calcular Cuotas");
            System.out.println("0.- Salir");

            System.out.print("Escoge una opción: ");
            opt = sc.next();

            switch (opt) {
                case "1":
                    anadeMascota(mascotas);

                    break;
                case "2":
                    visualizarListado(mascotas);

                    break;
                case "3":
                    if (mascotas.isEmpty()) {
                        System.out.println("No existen datos para eliminar");
                    } else {
                        eliminarMascota(mascotas);
                    }
                    break;
                case "4":
                    calcularCuotas(mascotas);

                    break;
                case "0":
                    System.out.println("Hasta luego.");

                    break;
                default:
                    System.out.println("Opción no válida");

                    break;
            }

            System.out.print("\n");

        } while (!opt.equals("0"));
        
    }

    /**
     * Añade una nueva mascota al mapa y lo escribe en el fichero
     * 
     * <ol>
     *      <li>El usuario indica que si quiere un Perro o un Gato</li>
     *      <li>Recoge los datos de propietario y genera el objecto {@code Propietario}</li>
     *      <li>Dependiendo de la opción del usuario, se crea un {@code Gato} o un {@code Perro}</li>
     * </ol>
     * 
     * Finalmente, añade la nueva mascota en el Mapa y en el fichero,
     * 
     * @param mascotas 
     */
    public static void anadeMascota(HashMap<String, Mascota> mascotas) {
        Scanner sc = new Scanner(System.in);
        Propietario propietario;
        Mascota nuevo = new Perro();

        String opt;
        String dni;
        String nombre;
        String apellidos;
        String identificador;
        String dato;
        int clase = 0;

        do {
            System.out.print("Indique el tipo de mascota, ¿Perro(1) o Gato(2)?: ");
            opt = sc.nextLine();

            if (!opt.matches("[12]")) {
                System.out.println("Opción no válida");
            }

        } while (!opt.matches("[12]"));

        System.out.print("Introduce el nombre: ");
        nombre = sc.nextLine();

        System.out.print("Introduce el apellidos: ");
        apellidos = sc.nextLine();

        System.out.print("Introduce el DNI del alumno (Debe ser valido): ");

        do {
            dni = sc.nextLine().toUpperCase();

            if (!Propietario.validarDni(dni)) {
                System.out.println("DNI no válido. Vuelve a introducirlo");
            }

        } while (!Propietario.validarDni(dni));

        propietario = new Propietario(dni, nombre, apellidos);

        System.out.print("Introduce el identificador de la mascota (Debe ser 5 numeros seguido de un guión \"-\" y entre 2 y 6 letras): ");

        do {
            identificador = sc.nextLine();

            if (!Mascota.validarCodigo(identificador)) {
                System.out.println("Identificador no válido. Vuelve a introducirlo");
            }

            if (mascotas.containsKey(identificador)) {
                System.out.println("Ya existe una mascota con ese identificador. Introduce uno nuevo");
            }

        } while (!Mascota.validarCodigo(identificador) || mascotas.containsKey(identificador));

        switch (opt) {
            case "1":
                System.out.println("Introduce el clase del perro (Disponible entre 1 y 4)");

                do {
                    dato = sc.next();

                    if (dato.matches("[0-9]{1,}")) {
                        clase = Integer.parseInt(dato);

                        if (!Perro.validarClase(clase)) {
                            System.out.println("Curso no válido. Vuelve a introducirlo");
                        }
                    } else {
                        System.out.println("Dato no válido. Vuelve a introducirlo");
                    }

                } while (!Perro.validarClase(clase));

                nuevo = new Perro(identificador, propietario, clase);
                break;
            case "2":
                System.out.println("Introduce el clase del gato (Disponible entre 1 y 3)");

                do {
                    dato = sc.next();

                    if (dato.matches("[0-9]{1,}")) {
                        clase = Integer.parseInt(dato);

                        if (!Gato.validarClase(clase)) {
                            System.out.println("Clase no válida. Vuelve a introducirlo");
                        }
                    } else {
                        System.out.println("Dato no válido. Vuelve a introducirlo");
                    }

                } while (!Gato.validarClase(clase));

                nuevo = new Gato(identificador, propietario, clase);
                break;
        }

        System.out.println("Se ha añadido correctamente\n");

        mascotas.put(nuevo.getIdentificador(), nuevo);
        escribirFichero(mascotas);
    }

    /**
     * Muestra los valores del Mapa de las mascotas.<br>
     * En el caso de que el Mapa no contenga nada, se muestra un mensaje al usuario
     * 
     * @param mascotas 
     */
    public static void visualizarListado(HashMap<String, Mascota> mascotas) {
        if (mascotas.isEmpty()) {
            System.out.println("No hay datos para mostrar: ");
        }

        for (Mascota a : mascotas.values()) {
            System.out.println(a.mostrar());
        }
    }

    /**
     * Elimina la Mascota del Mapa utilizando su identificador.
     * Revisa si existe esa mascota dentro del Mapa
     * 
     * Después, sobreescribe las mascotas que quedan en fichero
     * 
     * @param mascotas 
     */
    public static void eliminarMascota(HashMap<String, Mascota> mascotas) {
        Scanner sc = new Scanner(System.in);
        String idetificador;

        System.out.println("Estas son las mascotas registradas: ");

        for (String a : mascotas.keySet()) {
            System.out.println("\t" + a);
        }

        System.out.println("Indica el identificador del la mascota que quieres eliminar: ");

        do {
            idetificador = sc.next();

            if (!mascotas.containsKey(idetificador)) {
                System.out.println("No existe esa mascota con ese identificador o está mal escrito");
            }

        } while (!mascotas.containsKey(idetificador));

        System.out.println("Se ha eliminado la mascota correctamente");

        mascotas.remove(idetificador);
        escribirFichero(mascotas);
    }

    /**
     * Muestra por pantalla las coutas de todas las mascotas, las de los Perros y las de los Gatos
     * 
     * @param mascotas 
     */
    public static void calcularCuotas(HashMap<String, Mascota> mascotas) {
        int totalPerros = 0;
        int totalGatos = 0;
        int t;

        for (Tarifable a : mascotas.values()) {
            t = a.calcularCuota();

            if (a instanceof Perro) {
                totalPerros += t;
            }

            if (a instanceof Gato) {
                totalGatos += t;
            }
        }

        System.out.println("Cuotas por los perros: " + totalPerros + "€");
        System.out.println("Cuotas por los gatos: " + totalGatos + "€");
        System.out.println("Cuotas por todas las mascotas: " + (totalPerros + totalGatos) + "€");
    }

    /**
     * 
     * @param mascotas 
     */
    public static void escribirFichero(HashMap<String, Mascota> mascotas) {
        try {
            FileOutputStream fichero = new FileOutputStream(new File(FICHERO));
            ObjectOutputStream salida = new ObjectOutputStream(fichero);

            for (Mascota m : mascotas.values()) {
                salida.writeObject(m);
            }
            
            salida.close();
            fichero.close();
        } catch (IOException e) {
            // 
        }
    }

    public static void cargarDatos(HashMap<String, Mascota> mascotas) {
        Mascota m;
        FileInputStream fichero = null;
        ObjectInputStream entrada = null;

        try {
            fichero = new FileInputStream(new File(FICHERO));
            entrada = new ObjectInputStream(fichero);

            while ((m = (Mascota) entrada.readObject()) != null) {
                mascotas.put(m.getIdentificador(), m);
            }

        } catch (IOException | ClassNotFoundException e) {
        	//
        } finally {
            try {
                entrada.close();
                fichero.close();
            } catch (IOException ex) {
            	//
            }
        }
    }

}
