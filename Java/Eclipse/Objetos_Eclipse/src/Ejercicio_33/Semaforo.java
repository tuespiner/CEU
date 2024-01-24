package Ejercicio_33;

public class Semaforo {
	public static final String ROJO = "ROJO";
	public static final String AMBAR = "AMBAR";
	public static final String VERDE = "VERDE";
	
	private String color;
	private Boolean parpadeando;
	int i = 0;
	//CONSTRUCTORES
	public Semaforo() {
		this.color = ROJO;
		this.parpadeando = false;
		
	}
	
	//GETTERS AND SETTERS
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if (color.equalsIgnoreCase(ROJO) || color.equalsIgnoreCase(VERDE) || color.equalsIgnoreCase(AMBAR)) {
			this.color = color;
		}
		
	}

	public Boolean getParpadeando() {
		return parpadeando;
	}

	public void setParpadeando(Boolean parpadeando) {
		if(this.color.equalsIgnoreCase(AMBAR)) {
			this.parpadeando = parpadeando;
		}else if(this.color.equalsIgnoreCase(ROJO)||this.color.equalsIgnoreCase(VERDE)) {
			this.parpadeando = false;
		}
	}
	
	public void cambiarEstado() {
		if(this.color.equals(VERDE)) {
			this.setColor(AMBAR);
			this.setParpadeando(true);
		}else if(this.color.equals(AMBAR)&& this.parpadeando == true) {
			this.setParpadeando(false);
		}else if(this.color.equals(AMBAR) && this.parpadeando == false) {
			this.setColor(ROJO);
		}else {
			this.setColor(VERDE);
		}
	}

	//TO STRING
	@Override
	public String toString() {
		if(this.parpadeando == true) {
			return "Semaforo en " + color + " " + parpadeando ;
		}else {
			return "Semaforo en " + color ;
		}
		
	}
	
	
	
	
}
