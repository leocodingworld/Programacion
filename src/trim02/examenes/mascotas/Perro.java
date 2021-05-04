package trim02.examenes.mascotas;

@SuppressWarnings("serial")
public class Perro extends Mascota {
    private int clase;

    public Perro() {
    }

    public Perro(String identificador) {
        super(identificador);
    }

    public Perro(String identificador, Propietario propietario, int clase) {
        super(identificador, propietario);
        this.clase = clase;
    }
   
    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

    public static boolean validarClase(int clase) {
        return clase >= 1 && clase <= 4;
    }

    @Override
    public String mostrar() {
        return super.mostrar() + 
            "\n\tAnimal: Perro" +
            "\n\tClase: " + this.clase +
            "\n\tCouta: " + this.calcularCuota() + "€";
    }

    @Override
    public int calcularCuota() {        
        return super.calcularCuota() + (25 * this.clase); 
    }
		
}
