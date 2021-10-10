package com.cev.prueba.prueba.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cev.prueba.prueba.domain.Pelicula;

@Service
public class PeliculasEngService {

	List<Pelicula> peliculas = new ArrayList<Pelicula>();

	public PeliculasEngService() {
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo("Kill Bill");
		pelicula.setPuntuacion(10);
		pelicula.setSinopsis("(ENG) Uma Thurman in yellow jumpsuit and hitting sabers. What do you want more for?");
		pelicula.setFechaEstreno(new GregorianCalendar(2003, Calendar.JANUARY, 01).getTime());
		pelicula.setDirector("Quentin Tarantino");
		peliculas.add(pelicula);
	}	
	
	public Pelicula getPelicula(int id) {
		return peliculas.get(id-1);
	}
	
	public int add(Pelicula pelicula) {
		peliculas.add(pelicula);
		return peliculas.size();
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}
	
	public void guarda(int id, Pelicula pelicula ) {
		peliculas.set(id-1, pelicula);
	}
	
	public void borra(int id) {
		peliculas.remove(id-1);
	}
	
	public  List<Pelicula> buscaPorTitulo(String titulo) {
		
		List<Pelicula> peliculasResultado = new ArrayList<Pelicula>();	
		for(Pelicula pelicula: peliculas) {
			if( pelicula.getTitulo().contains(titulo)) {
				peliculasResultado.add(pelicula);
			}
		}
		return peliculasResultado;	
	}
	

}
