package com.example.PalindromoAPI.exception;

public class PalindromeProcessingException extends RuntimeException {
    public PalindromeProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}