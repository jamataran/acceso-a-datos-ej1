package com.cev.prueba.prueba.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cev.prueba.prueba.web.error.TeapotException;

@RestController("/tes")
public class TesController {

    @GetMapping
    public ResponseEntity<Boolean> getTeapotError() {
        throw new TeapotException("Mensaje de la Excepcion");
    }

}
