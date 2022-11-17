package io.eurekalabs.challenge.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomResponseExceptionHandler {

    @ExceptionHandler(CustomResponseException.class)
    public ResponseEntity<Object> handleCustomResponseException(CustomResponseException customResponseException) {
        return new ResponseEntity<>(customResponseException.getReason(), customResponseException.getStatus());
    }

}
