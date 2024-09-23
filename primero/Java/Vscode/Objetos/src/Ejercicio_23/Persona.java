package Ejercicio_23;

public class Persona {
	private String nombre;
	private Integer edad;
	private String dni;

    //CONSTRUCTOR
	public Persona(String nombre, Integer edad, String dni) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni= dni;
	}

	public Persona() {
		this.nombre = "";
		this.edad = 0;
		this.dni = "";
	}

	public Persona(String dni){
		this.dni = dni;
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
        this.dni = dni;
    }

}
