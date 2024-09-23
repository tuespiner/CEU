package Ejercicio_11;

import java.time.LocalDate;
import java.util.List;

public class Nodo {
	private Nodo progenitor1;
	private Nodo progenitor2;
	private Nodo conyuge;
	private String nombre;
	private LocalDate fechaNacimiento;
	private LocalDate fechaDeceso;
	private List<Nodo> hijos;
	
	public Nodo() {
	}
	
	public Nodo getProgenitor1() {
		return progenitor1;
	}



	public void setProgenitor1(Nodo progenitor1) {
		this.progenitor1 = progenitor1;
	}



	public Nodo getProgenitor2() {
		return progenitor2;
	}



	public void setProgenitor2(Nodo progenitor2) {
		this.progenitor2 = progenitor2;
	}



	public Nodo getConyuge() {
		return conyuge;
	}



	public void setConyuge(Nodo conyuge) {
		this.conyuge = conyuge;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public LocalDate getFechaDeceso() {
		return fechaDeceso;
	}



	public void setFechaDeceso(LocalDate fechaDeceso) {
		this.fechaDeceso = fechaDeceso;
	}



	public List<Nodo> getHijos() {
		return hijos;
	}



	public void setHijos(List<Nodo> hijos) {
		this.hijos = hijos;
	}



	public void establecerConyuge(Nodo conyuge)throws ConyugeException {
			if(this.conyuge == null) {
				this.conyuge = conyuge;
			}else {
				throw new ConyugeException("Este nodo ya dispone de un conyuge");
			}
	}
	
	public void addHijo(String nombre, LocalDate fechaNacimiento) throws ConyugeException{
		if(this.conyuge != null) {
			Nodo hijo = new Nodo();
			hijo.setNombre(nombre);
			hijo.setFechaNacimiento(fechaNacimiento);
			hijo.setProgenitor1(this);
			hijo.setProgenitor2(conyuge);
			this.hijos.add(hijo);
			this.conyuge.getHijos().add(hijo);
		}else {
			throw new ConyugeException("No se puede añadir un hijo sin un conyuge");
		}
	}
}
