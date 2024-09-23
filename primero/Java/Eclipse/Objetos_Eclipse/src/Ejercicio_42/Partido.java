package Ejercicio_42;

public class Partido {
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Resultado resultado;
	
	public Partido() {
	}
	
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public Resultado getResultado() {
		return resultado;
	}
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
	public String toString() {
		return this.equipoLocal + " vs " + this.equipoVisitante + " ["+this.resultado+"]";
	}
	
	public Equipo getEquipoGanador() {
		if(this.getResultado().isVictoriaLocal()) {
			return this.equipoLocal;
		}else if(this.getResultado().isVictoriaVisitante()) {
			return this.equipoVisitante;
		}else{
			return null;
		}
	}
	
}
