package Ejercicio_43;

public class Actor extends Trabajador {
    private Integer sueldo;

    public Actor(String nomb, Integer fechaNac, String nacio) {
        super(nomb, fechaNac, nacio);
        this.sueldo = ACTOR;
    }

    public Actor() {
        super();
        this.sueldo = ACTOR;
    }

    @Override
    public Integer getSueldo() {
        return ACTOR;
    }

}
