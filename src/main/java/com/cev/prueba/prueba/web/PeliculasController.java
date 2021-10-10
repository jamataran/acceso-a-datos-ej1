package com.cev.prueba.prueba.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cev.prueba.prueba.domain.Pelicula;
import com.cev.prueba.prueba.service.PeliculasEngService;
import com.cev.prueba.prueba.service.PeliculasService;
import com.cev.prueba.prueba.web.error.CustomError;

@RestController
public class PeliculasController {

    private static final String SPANISH_ACCEPT_LANGUAGE = "es-ES";
    private static final String ACCEPT_LANGUAGE = "accept-language";
    private final PeliculasService peliculasService;
    private final PeliculasEngService peliculasEngService;

    public PeliculasController(PeliculasService peliculasService,
                               PeliculasEngService peliculasEngService) {
        this.peliculasService = peliculasService;
        this.peliculasEngService = peliculasEngService;
    }


    @GetMapping(path = "/peliculas")
    List<Pelicula> getPeliculas(@RequestParam(required = false) String titulo,
                                @RequestParam(required = false, name = "puntuacion.min", defaultValue = "2") Integer puntuacionMinima,
                                @RequestParam(required = false, name = "puntuacion.max") Integer puntuacionMaxima) {
        if (puntuacionMinima < 2) {
            throw new CustomError("La puntuacion no puede ser menor que 2");
        }

        if (puntuacionMinima != null && puntuacionMaxima != null && puntuacionMinima > puntuacionMaxima)
            throw new CustomError("La puntuacion minima tiene que ser menor que la maxima");


        // Filtro las peliculas por titulo
        final List<Pelicula> peliculas = new ArrayList<>();
        if (titulo != null) {
            peliculas.addAll(peliculasService.buscaPorTitulo(titulo));
        } else {
            peliculas.addAll(peliculasService.getPeliculas());
        }

        // Filtro las peliculas por puntuación
        return peliculas
                .stream()
                .filter(pelicula -> {
                    boolean peliculaDentroDeLimites = true;
                    if (puntuacionMinima != null && pelicula.getPuntuacion() < puntuacionMinima)
                        peliculaDentroDeLimites = false;

                    if (puntuacionMaxima != null && pelicula.getPuntuacion() > puntuacionMaxima)
                        peliculaDentroDeLimites = false;

                    return peliculaDentroDeLimites;
                })
                .collect(Collectors.toList());

    }


    @GetMapping(path = "/peliculas/{id}")
    Pelicula getPeliculas(@PathVariable int id, @RequestHeader(ACCEPT_LANGUAGE) String acceptLanguage) {
        return SPANISH_ACCEPT_LANGUAGE.equalsIgnoreCase(acceptLanguage) ? peliculasService.getPelicula(id) : peliculasEngService.getPelicula(id);
    }

    @PostMapping(path = "/peliculas")
    int altaPelicula(@RequestBody Pelicula pelicula) {
        return peliculasService.add(pelicula);
    }

    @PutMapping(path = "/peliculas/{id}")
    Pelicula modificaPelicula(@RequestBody Pelicula pelicula, @PathVariable int id) {
        peliculasService.guarda(id, pelicula);
        return pelicula;
    }

    @DeleteMapping(path = "/peliculas/{id}")
    String borraPelicula(@PathVariable int id) {
        peliculasService.borra(id);
        return ("OK");
    }

    @GetMapping(path = "/peliculasHeader")
    ResponseEntity<List<Pelicula>> getPeliculasHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("MiHeaderRespuesta", "HeaderRespuesta");

        return ResponseEntity.ok().headers(headers).body(peliculasService.getPeliculas());
    }


}

