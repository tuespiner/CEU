package Ejercicio_25;

public class Alumno extends Persona {
	private Double nota;
	private Curso curso;

	// CURSO
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	// NOTA
	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	// CONSTRUCTOR VALORES INTRODUCIDOS EN SU CREACIÓN
	public Alumno(String dni, String nombre, Integer edad, Double nota, Curso curso) {
		super(nombre, edad, dni);
		this.nota = nota;
		this.curso = curso;
	}

	// CONSTRUCTOR VALORES SIN INTRODUCIR
	public Alumno() {
		super();
		this.nota = 0d;
	}

	public Alumno(String dni) {
		super(dni);
	}
	public Alumno(String dni, Curso curso) {
		super(dni);
		this.curso = curso;
	}
	public Alumno (Curso curso) {
		this.curso = curso;
	}

	// PONE LA NOTA A 5
	public void aprobar() {
		this.nota = 5.0;
	}
	
	//TO STRING
	@Override
	public String toString() {
		String objeto = "Nombte: " + this.getNombre() + ", Edad: " + this.getEdad() + ", DNI: " + this.getDni()
				 + curso + ", Nota: "+nota;
		return objeto;
	}
}
