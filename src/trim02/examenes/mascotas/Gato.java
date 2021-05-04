package trim02.examenes.mascotas;

@SuppressWarnings("serial")
public class Gato extends Mascota{
    private int clase;

    public Gato() {
    }

    public Gato(String identificador) {
        super(identificador);
    }

    public Gato(String identificador, Propietario propietario, int clase) {
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
        return clase >= 1 && clase <= 3;
    }

    @Override
    public String mostrar() {
        return super.mostrar() + 
            "\n\tAnimal: Gato" +
            "\n\tClase: " + this.clase +
            "\n\tCouta: " + this.calcularCuota() + "€"; 
    }

    @Override
    public int calcularCuota() {
            return super.calcularCuota() + (15 * this.clase); 
    }
	
}
