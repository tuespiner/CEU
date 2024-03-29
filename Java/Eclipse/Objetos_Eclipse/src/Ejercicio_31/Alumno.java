package Ejercicio_31;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alumno extends Persona {

	private Double nota;
	private Curso curso;

// ----------------------------------------------------------------------------

	// CONSTRUCTORES
		//CONSTRUCTOR DNI, NOMBRE, EDAD, NOTA Y CURSO
	public Alumno(String dni, String nombre, Integer edad, Double nota, Curso curso) {
		super(nombre, edad, dni);
		this.nota = nota;
		this.curso = curso;
	}
		//CONSTRUCTOR DNI, CURSO
	public Alumno(String dni, Curso curso) {
		super(dni);
		this.curso = curso;
	}
		//CONSTRUCTOR DNI
	public Alumno(String dni) {
		super(dni);
	}
		//CURSO
	public Alumno(Curso curso) {
		this.curso = curso;
	}
		//VACIO
	public Alumno() {
		
	}

// ----------------------------------------------------------------------------
	
	// SETTERS AND GETTERS
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

// ----------------------------------------------------------------------------
	
	//MÉTODOS
		// PONE LA NOTA A 5
	public void aprobar() {
		this.nota = 5.0;
	}
	
		// TO STRING
	@Override
	public String toString() {
		String objeto = "Nombre: " + this.getNombre() + ", Edad: " + this.getEdad() + ", DNI: " + this.getDni() + ", " +curso
				+ ", Nota: " + nota;
		return objeto;
	}
	
		//VALIDA EL DNI
	public static Boolean validarDni(String dni) {
		if (dni == null) {
			return false;
		} else if (dni.length() < 9) {
			return false;
		} else {
			Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
			Matcher match = patron.matcher(dni);
			if (match.matches()) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	
		//VALIDAR USUARIO ALUMNO
	public static Boolean validar(Alumno alumno) {
		if (Alumno.validarDni(alumno.getDni())==true) {
			if (alumno.getCurso()!=null) {
				if (alumno.getNombre()!= null && alumno.getNombre().length() >10) {
					if (alumno.getEdad()!= null && alumno.getEdad()<= 65 && alumno.getEdad()>=12) {
						return true;
					}else {
						return false;
					}
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
		//VALIDA UN OBJETO ALUMNO ENTERO
	/*public static Boolean validar(Alumno alumno) {
		Scanner sc = new Scanner(System.in);
		do {
			if (Alumno.validarDni(alumno.getDni()) == false) {
				while (true) {
					System.out.println("DNI: wrong");
					System.err.println("El dni no es valido, porfavor ingrese uno valido");
					alumno.setDni(sc.nextLine());
					if (Alumno.validarDni(alumno.getDni()) == true) {
						break;
					}
				}

			}
		} while (Alumno.validarDni(alumno.getDni()) != true);
		System.out.println("DNI: ok");
		do {
			if (alumno.getNombre() == null) {
				System.out.println("Nombre: wrong");
				System.err.println("El nombre es obligatorio");
				alumno.setNombre(sc.nextLine());
			} else {
				if (alumno.getNombre().length() < 10) {
					System.out.println("Nombre: wrong");
					System.err.println("El nombre tiene menos de 10 caracteres");
					alumno.setNombre(sc.nextLine());
				} else {
					break;
				}
			}
		} while (alumno.getNombre() == null || alumno.getNombre().length() < 10);
		System.out.println("Nombre: ok");
		do {
			Curso curso = new Curso();
			if (alumno.getCurso() == null) {
				System.out.println("Curso: wrong");
				System.err.println("El campo curso es obligatorio\ndime el numero del curso");
				curso.setIdentificador(sc.nextInt());
				sc.nextLine();
				System.err.println("Dime el curso");
				curso.setDescripcion(sc.nextLine());
				alumno.setCurso(curso);
			} else {
				break;
			}
		} while (alumno.getCurso() == null);
		System.out.println("Curso: ok");
		do {
			if (alumno.getEdad() == null) {
				System.out.println("Edad: wrong");
				System.err.println("El campo edad tiene que tener algun valor");
				alumno.setEdad(sc.nextInt());
			} else {
				if (alumno.getEdad() < 12 || alumno.getEdad() > 65) {
					System.out.println("Edad: wrong");
					System.err.println("El campo edad tiene que ser entre 12 y 65 años");
					alumno.setEdad(sc.nextInt());
				} else {
					break;
				}
			}
		} while (alumno.getEdad() == null || alumno.getEdad() < 12 || alumno.getEdad() > 65);
		System.out.println("Edad: ok");
		return true;
	}*/
	
	
}
