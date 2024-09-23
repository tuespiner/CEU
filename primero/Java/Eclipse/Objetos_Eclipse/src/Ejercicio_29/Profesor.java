package Ejercicio_29;

public class Profesor extends Persona{
    private Curso curso;

    //CONSTRUCTORES
    public Profesor(String nombre, Integer edad, String dni, Curso curso){
        super(nombre, edad, dni);
        this.curso = curso;
    }

    public Profesor(){
        super();
    }

    //CURSO
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public String toString() {
    	String objeto = "Nombte: "+ this.getNombre() + ", Edad: " + this.getEdad() + ", DNI: "+this.getDni()+curso;
    	return objeto;
    }
    
}
