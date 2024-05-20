package Examen.Modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

public class Pelicula {
	private String titulo;
	private Integer duracion;
	private LocalDate fechaRodaje;
	private LocalDate fechaEstreno;
	private BigDecimal presupuestoIni;
	private BigDecimal recaudacion;
	private List<Actor> reparto;
	
	public Pelicula(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public LocalDate getFechaRodaje() {
		return fechaRodaje;
	}
	public void setFechaRodaje(LocalDate fechaRodaje) {
		this.fechaRodaje = fechaRodaje;
	}
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public BigDecimal getPresupuestoIni() {
		return presupuestoIni;
	}
	public void setPresupuestoIni(BigDecimal presupuestoIni) {
		this.presupuestoIni = presupuestoIni;
	}
	public BigDecimal getRecaudacion() {
		return recaudacion;
	}
	public void setRecaudacion(BigDecimal recaudacion) {
		this.recaudacion = recaudacion;
	}
	public List<Actor> getReparto() {
		return reparto;
	}
	public void setReparto(List<Actor> reparto) {
		this.reparto = reparto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(titulo, other.titulo);
	}
	
	
	public BigDecimal getBeneficios() {
		BigDecimal beneficios = BigDecimal.ZERO;
		beneficios = this.recaudacion.subtract(presupuestoIni).setScale(2,RoundingMode.HALF_DOWN);
		if(beneficios.compareTo(BigDecimal.ZERO) <= 0) {
			beneficios = BigDecimal.ZERO;
		}
		return beneficios;
	}
	
	public Integer getTiempoRodaje() {
		Period periodo = this.fechaRodaje.until(this.fechaEstreno);
		Integer tiempoRodaje = periodo.getMonths();
		return tiempoRodaje;
	}

	@Override
	public String toString() {
		return this.titulo+" ("+this.duracion+") // Recaudación: "+this.recaudacion.toString()+" € ("+this.presupuestoIni.toString()+" €)";
	}
	
	
}
