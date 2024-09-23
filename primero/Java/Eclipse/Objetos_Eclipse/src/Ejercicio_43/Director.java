package Ejercicio_43;

public class Director extends Trabajador {
    private Integer sueldo;

    public Director(String nomb, Integer fechaNac, String nacio) {
        super(nomb, fechaNac, nacio);
        this.sueldo = DIRECTOR;
    }

    public Director() {
        super();
        this.sueldo = DIRECTOR;
    }

    @Override
    public Integer getSueldo() {
        return this.sueldo;
    }

}
