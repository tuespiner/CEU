package Ejercicio_21;

public class Alumno extends Persona{
	private String dni;
	private String nombre;
	private Integer edad;
	private Double nota;
	//DNI
	public String getDni() {
		return dni;
	}
	public void setDni(String Dni) {
		this.dni = Dni;
	}
	//NOMBRE
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//EDAD
	public Integer getEdad() {
		return edad;
	}
	
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	//NOTA
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	//CONSTRUCTOR VALORES INTRODUCIDOS EN SU CREACIÓN
	public Alumno(String dni, String nombre, Integer edad, Double nota) {
		super(nombre,edad);
		this.dni = dni;
		this.nota = nota;
	}
	//CONSTRUCTOR VALORES SIN INTRODUCIR
	public Alumno() {
		super();
		this.dni = "";
		this.nota =0d;
	}
	public Alumno(String dni) {
		super();
		this.dni = dni;
	}
	//PONE LA NOTA A 5
	public void aprobar() {
		this.nota = 5.0;
	}
	
}
