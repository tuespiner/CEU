package Ejercicio_2_repaso;

public class Telefono {
	private Integer numero;
	private Boolean enLlamada;
	
	public Integer consultarNumero() {
		return this.numero;
	}

	public void marcar(Integer numeroTel) {
		System.out.println("Llamando a " + numeroTel);
		if(numeroTel == this.numero) {
			System.out.println("Comunicando");
		}else {
			System.out.println("En comunicacion");
			this.enLlamada = true;
		}
	}

	public void colgar() {
		if(this.enLlamada) {
			System.out.println("Comunicación terminada");
		}
		
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Boolean getEnLlamada() {
		return enLlamada;
	}

	public void setEnLlamada(Boolean enLlamada) {
		this.enLlamada = enLlamada;
	}
	
	
}
