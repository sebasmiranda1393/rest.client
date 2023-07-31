package com.proyect.ntt.data.rest.client.error;

import com.proyect.ntt.data.rest.client.exception.NoFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;


@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {
    private static final ConcurrentHashMap<String, Integer> EXCEPTION_LIST = new ConcurrentHashMap<>();
    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrió un error favor contactar al administrador.";

    public ExceptionHandling() {
        EXCEPTION_LIST.put(NoFoundException.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> resultado = null;

        String exceptionName = exception.getClass().getSimpleName();
        String message = exception.getMessage();
        Integer code = EXCEPTION_LIST.get(exceptionName);
        if (code != null) {
            Error error = new Error(message,OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(code));

        }
        return resultado;
    }

}
