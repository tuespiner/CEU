package Ejercicio_30;

public class Curso {
    private Integer identificador;
    private String descripcion;
    private static Alumno[] alumnos;
    
 //----------------------------------------------------------------------------
    
    //CONSTRUCTORES
    	//CONSTRUCTOR ID, DESC Y ALUMNOS
    public Curso(int i, String desc, Integer numeroAlumnos) {
        this.identificador = i;
        this.descripcion = desc;
        this.alumnos=new Alumno[numeroAlumnos];
    }
    	//CONSTRUCTOR ID, DESC
    public Curso(int i, String desc) {
    	this.identificador = i;
    	this.descripcion =desc;
    }
    	//CONSTRUCTOR ALUMNOS
    public Curso(Integer numeroAlumnos) {
    	this.alumnos = new Alumno[numeroAlumnos];
    }
    	//CONSTRUCTOR VACÍO
    public Curso() {
    	
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
    public Alumno[] getAlumnos() {
    	return alumnos;
    }
    public String toString() {
    	String objeto = "Curso: "+identificador + descripcion;
    	return objeto;
    }
    
  //----------------------------------------------------------------------------
    
    //MÉTODOS
    	//AÑADIR ALUMOS AL ARRAY
    public static void addAlumno(Alumno alumno) {
    	int contEspacioVacio = 0;
    	int cont = 0;
    	for(Alumno alumnoArr : alumnos) {
    		cont++;
    		if(alumnoArr == null) {
    			System.out.println("Alumno añadido correctamente en la posición "+cont);
    			alumnoArr = alumno;
    			contEspacioVacio++;
    		}
    	}
    	if(contEspacioVacio == 0) {
    		System.out.println("No hay mas huecos en esta clase");
    	}
    }
}
