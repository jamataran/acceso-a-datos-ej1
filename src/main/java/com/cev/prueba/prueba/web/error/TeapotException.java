package com.cev.prueba.prueba.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
public class TeapotException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TeapotException(String message) {
        super(message);
    }

}
