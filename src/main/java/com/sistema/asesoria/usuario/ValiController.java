package com.sistema.asesoria.usuario;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValiController {
    
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)// retorna un 400 que es un bad request
    @ExceptionHandler(MethodArgumentNotValidException.class)// sobre este metodo entrara todas las exepciones
    public Map<String, String> handleValidateExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{
            String fielName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fielName, message);
        });
        return errors;
    }

}
