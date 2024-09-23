package Ejercicio_31;

import java.util.Objects;

public class Persona {
	private String nombre;
	private Integer edad;
	private String dni;

    //CONSTRUCTOR
	public Persona(String nombre, Integer edad, String dni) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni= dni.toUpperCase();
	}

	public Persona() {
		
	}

	public Persona(String dni){
		this.dni = dni.toUpperCase();
	}

	// SETTERS AND GETTERS
		// NOMBRE
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

		// EDAD
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	//DNI
	public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni.toUpperCase();
    }
    
    public static Boolean validarDni(String dni) {
    	if(dni == null) {
    		return false;
    	}else if(dni.length()<=9) {
    		return false;
    	}else {
    		return true;
    	}
    }
    
    //MÉTODO TO STRING
    @Override
    public String toString() {
    	String objeto = "Nombte: "+nombre + ", Edad: " + edad + ", DNI: "+dni;
    	return objeto;
    }
    
    //EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}
}
