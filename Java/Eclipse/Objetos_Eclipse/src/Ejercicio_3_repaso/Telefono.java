package Ejercicio_3_repaso;

public class Telefono {
	private Integer numero;
	private Boolean enLlamada;
	
	public Telefono(Integer numero) {
		this.numero = numero;
		this.enLlamada = false;
	}
	
	public Integer consultarNumero() {
		return this.numero;
	}

	public void marcar(int numeroTel) {
		System.out.println("Llamando a " + numeroTel);
		if(this.numero == numeroTel) {
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
