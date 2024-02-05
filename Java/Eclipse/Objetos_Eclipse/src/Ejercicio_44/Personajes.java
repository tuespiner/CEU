package Ejercicio_44;

public abstract class  Personajes {
	protected static final Integer VIDA_ASESINO = 100;
	protected static final Integer VIDA_PARASITO = 200;
	protected static final Integer DAÑO_ASESINO	= 10;
	protected static final Integer DAÑO_PARASITO = 2;
	protected static final Integer FRECUENCIA_ASESINO = 5;
	protected static final Integer FRECUENCUA_PARASITO = 1;

	
	private Integer puntosDeVida;
	private Integer daño;
	private Integer frecuencia;
	private String nombre;
	private String codigo;
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Personajes() {
		
	}
	
	public abstract Integer getPuntosDeVida();
	public void setPuntosDeVida(Integer puntosDeVida) {
		this.puntosDeVida = puntosDeVida;
	}
	public abstract Integer getDaño();
	public void setDaño(Integer daño) {
		this.daño = daño;
	}
	public abstract Integer getFrecuencia();
	public void setFrecuencia(Integer frecuencia) {
		this.frecuencia = frecuencia;
	}

	@Override
	public String toString() {
		return "Personajes [puntosDeVida=" + puntosDeVida + ", daño=" + daño + ", frecuencia=" + frecuencia
				+ ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}
	
	
}
