package Ejercicio_36;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private Integer identificador;
    private String descripcion;
    private List<Alumno> alumnos;
    
 //----------------------------------------------------------------------------
    
    //CONSTRUCTORES
    	//CONSTRUCTOR ID, DESC Y ALUMNOS
    public Curso(int i, String desc) {
        this.identificador = i;
        this.descripcion = desc;
        this.alumnos=new ArrayList<>();
    }
    	//CONSTRUCTOR ALUMNOS
    public Curso() {
    	this.alumnos = new ArrayList<>();;
    }
    
//----------------------------------------------------------------------------
    
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
    	//ALUMNOS
    public List<Alumno> getAlumnos() {
    	return this.alumnos;
    }
    public String toString() {
    	String objeto = "Curso: "+identificador + descripcion;
    	return objeto;
    }
    
  //----------------------------------------------------------------------------
    
    //MÉTODOS
    	//AÑADIR ALUMOS A LA LISTA
    public void addAlumno(Alumno alumno) {
    	alumnos.add(alumno);
    }
}
