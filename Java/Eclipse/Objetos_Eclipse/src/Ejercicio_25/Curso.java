package Ejercicio_25;

public class Curso {
    private Integer identificador;
    private String descripcion;
    
    //CONSTRUCTOR
    public Curso(int i, String desc) {
        this.identificador = i;
        this.descripcion = desc;
    }
    //SETTERS AND GETTERS
        //IDENTIFICADOR
    public Integer getIdentificador() {
        return identificador;
    }
    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }
        //DESCRIPCION
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String toString() {
    	String objeto = ", Curso: "+identificador + descripcion;
    	return objeto;
    }
}
