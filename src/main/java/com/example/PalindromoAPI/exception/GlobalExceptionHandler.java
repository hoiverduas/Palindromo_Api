package com.example.PalindromoAPI.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PalindromeInputException.class)
    public ResponseEntity<String> handlePalindromeInputException(PalindromeInputException ex, WebRequest request) {
        return new ResponseEntity<>("Error de entrada: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PalindromeProcessingException.class)
    public ResponseEntity<String> handlePalindromeProcessingException(PalindromeProcessingException ex, WebRequest request) {
        return new ResponseEntity<>("Error en el procesamiento: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
