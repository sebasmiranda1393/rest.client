package com.proyect.ntt.data.rest.client.error;

import com.proyect.ntt.data.rest.client.exception.BadRequestException;
import com.proyect.ntt.data.rest.client.exception.CharacterInvalidateException;
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

    public ExceptionHandling() {
        EXCEPTION_LIST.put(NoFoundException.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
        EXCEPTION_LIST.put(BadRequestException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        EXCEPTION_LIST.put(CharacterInvalidateException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());

    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> resultado = null;

        String exceptionName = exception.getClass().getSimpleName();
        String message = exception.getMessage();
        Integer code = EXCEPTION_LIST.get(exceptionName);
        if (code != null) {
            Error error = new Error(exceptionName, message);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(code));

        }
        return resultado;
    }

}
