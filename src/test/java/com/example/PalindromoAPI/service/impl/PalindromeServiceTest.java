package com.example.PalindromoAPI.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.PalindromoAPI.entity.ResponseJson;
import com.example.PalindromoAPI.exception.PalindromeInputException;
import com.example.PalindromoAPI.exception.PalindromeProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

public class PalindromeServiceTest {

    @InjectMocks
    private PalindromeService palindromeService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void checkPalindrome_validPalindrome_returnsCorrectResponse() throws PalindromeInputException, PalindromeProcessingException {
        String palindrome = "Anita lava la tina";

        ResponseJson response = palindromeService.checkPalindrome(palindrome);

        assertEquals(palindrome.length(), response.getLengthCadena());
        assertEquals(1, response.getIsPalindromo()); // Es un palíndromo
        assertEquals(0, response.getLengthCaracteresEspeciales()); // Sin caracteres especiales
    }

    @Test
    void checkPalindrome_notPalindrome_returnsCorrectResponse() throws PalindromeInputException, PalindromeProcessingException {
        String nonPalindrome = "Hola Mundo";

        ResponseJson response = palindromeService.checkPalindrome(nonPalindrome);

        assertEquals(nonPalindrome.length(), response.getLengthCadena());
        assertEquals(0, response.getIsPalindromo()); // No es un palíndromo
        assertEquals(0, response.getLengthCaracteresEspeciales()); // Sin caracteres especiales
    }




    @Test
    void checkPalindrome_nullInput_throwsPalindromeInputException() {
        assertThrows(PalindromeInputException.class, () -> {
            palindromeService.checkPalindrome(null);
        });
    }

    @Test
    void checkPalindrome_emptyInput_throwsPalindromeInputException() {
        assertThrows(PalindromeInputException.class, () -> {
            palindromeService.checkPalindrome("");
        });
    }

    @Test
    void checkPalindrome_validStringWithSpecialCharacters_returnsCorrectResponse() throws PalindromeInputException, PalindromeProcessingException {
        String palindrome = "A man, a plan, a canal: Panama!";

        ResponseJson response = palindromeService.checkPalindrome(palindrome);

        assertEquals(palindrome.length(), response.getLengthCadena()); // Longitud total de la cadena
        assertEquals(1, response.getIsPalindromo()); // Se espera que sea un palíndromo
        assertEquals(4, response.getLengthCaracteresEspeciales()); // Contando: , : !
    }





}
