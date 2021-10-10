package com.cev.prueba.prueba.domain;

import java.util.Date;

public class Pelicula {
	
	String titulo;
	int puntuacion;
	String sinopsis;
	String director;
	Date fechaEstreno;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", puntuacion=" + puntuacion + ", sinopsis=" + sinopsis + ", director="
				+ director + ", fechaEstreno=" + fechaEstreno + "]";
	}
	

}
