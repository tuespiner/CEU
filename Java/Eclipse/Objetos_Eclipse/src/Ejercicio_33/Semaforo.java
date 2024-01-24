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
		i++;
		if (i == 1) {
			this.setColor(VERDE);
			
		}else if(i==2) {
			this.setColor(AMBAR);
			this.setParpadeando(true);
		}else if(i==3) {
			this.setColor(AMBAR);
			this.setParpadeando(false);
		}else {
			this.setColor(ROJO);
			i = 0;
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
