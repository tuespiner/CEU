package Ejercicio_43;

public class Guionista extends Trabajador {
    private Integer sueldo;

    public Guionista(String nomb, Integer fechaNac, String nacio) {
        super(nomb, fechaNac, nacio);
        this.sueldo = GUIONISTA;
    }

    public Guionista() {
        super();
        this.sueldo = GUIONISTA;
    }

    @Override
    public Integer getSueldo() {
        return GUIONISTA;
    }

}
