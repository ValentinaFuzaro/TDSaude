package br.fiap.com.api.config;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.fiap.com.api.models.RestValidationError;


@RestControllerAdvice
public class RestExceptionHandler {

    Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<RestValidationError>> methodArgumentNotValidExceptionHandler(
            MethodArgumentNotValidException erro) {
        log.error("erro");
        List<RestValidationError> errors = new ArrayList<>();
        erro.getFieldErrors().forEach(
                objeto -> errors.add(new RestValidationError(400, objeto.getField(), objeto.getDefaultMessage())));
        return ResponseEntity.badRequest().body(errors);
    }

}