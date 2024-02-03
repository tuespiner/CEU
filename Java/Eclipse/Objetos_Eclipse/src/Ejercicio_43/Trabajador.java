package Ejercicio_43;

public abstract class Trabajador {
	private String nombre;
	private Integer añoNacimiento;
	private String nacionalidad;

	protected static final Integer GUIONISTA = 50000;
	protected static final Integer DIRECTOR = 200000;
	protected static final Integer ACTOR = 100000;

	public Trabajador(String nomb, Integer añoNac, String nacio) {
		this.nombre = nomb;
		this.añoNacimiento = añoNac;
		this.nacionalidad = nacio;
	}

	public Trabajador() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAñoNacimiento() {
		return añoNacimiento;
	}

	public void setAñoNacimiento(Integer añoNacimiento) {
		this.añoNacimiento = añoNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	
	
	@Override
	public String toString() {
		return "Trabajador [nombre=" + nombre + ", añoNacimiento=" + añoNacimiento + ", nacionalidad=" + nacionalidad
				+ "]";
	}

	public abstract Integer getSueldo();

}
