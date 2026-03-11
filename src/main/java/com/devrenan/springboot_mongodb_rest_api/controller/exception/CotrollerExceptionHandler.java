package com.devrenan.springboot_mongodb_rest_api.controller.exception;

import com.devrenan.springboot_mongodb_rest_api.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CotrollerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception,
                                                        HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado!", exception.getMessage(), request.getRequestURI());
                                            //instante atual do sistema   | status de erro       | msg de erro       | message             | Path

        return ResponseEntity.status(status).body(error);


    }

}
