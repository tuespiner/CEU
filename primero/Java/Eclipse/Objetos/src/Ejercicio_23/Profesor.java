package Ejercicio_23;

public class Profesor extends Persona{
    private Curso curso;

    //CONSTRUCTORES
    public Profesor(String nombre, Integer edad, String dni, Curso curso){
        super(nombre, edad, dni);
        this.curso = curso;
    }

    public Profesor(){
        super();
        this.curso= "";
    }

    //CURSO
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
