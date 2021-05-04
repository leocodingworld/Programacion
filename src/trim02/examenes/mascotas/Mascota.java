package trim02.examenes.mascotas;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public abstract class Mascota implements Tarifable, Serializable {
    private String identificador;
    private Propietario propietario;    

    public Mascota() {
    }

    public Mascota(String identificador) {
        this.identificador = identificador;
    }

    public Mascota(String identificador, Propietario propietario) {
        this.identificador = identificador;
        this.propietario = propietario;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public static boolean validarCodigo(String codigo) { 
        return codigo.matches("[0-9]{5}-[a-zA-Z]{2,6}");
    }
	
    @Override
    public int calcularCuota() {
        return 350;
    }

    public String mostrar() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Mascota:\n" + this.propietario.mostrarPropietario() + 
                "\n\tIdentificador: " + this.identificador;
    }

    @Override
    public boolean equals(Object obj) {
        final Mascota other = (Mascota) obj;
        return Objects.equals(this.identificador, other.identificador);
    }
               
}
