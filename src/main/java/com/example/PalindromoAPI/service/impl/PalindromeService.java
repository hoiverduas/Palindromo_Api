package com.example.PalindromoAPI.service.impl;

import com.example.PalindromoAPI.entity.ResponseJson;
import com.example.PalindromoAPI.exception.PalindromeInputException;
import com.example.PalindromoAPI.exception.PalindromeProcessingException;
import com.example.PalindromoAPI.service.IPalindromeService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PalindromeService implements IPalindromeService {

    private final RestTemplate restTemplate;

    public PalindromeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseJson checkPalindrome(String palindromo) throws PalindromeInputException, PalindromeProcessingException {

        if (palindromo == null || palindromo.isEmpty()) {
            throw new PalindromeInputException("La cadena proporcionada es nula o vacía.");
        }

        try {

            String cleanString = palindromo.replaceAll("[^a-zA-Z0-9áéíóúüñ]", "").toLowerCase();
            boolean isPalindrome = cleanString.equals(new StringBuilder(cleanString).reverse().toString());

            int lengthCadena = palindromo.length();
            int lengthCaracteresEspeciales = 0;


            for (char c : palindromo.toCharArray()) {
                if (!Character.isLetterOrDigit(c) && c != ' ') {
                    lengthCaracteresEspeciales++;
                }
            }

            return new ResponseJson(lengthCadena, isPalindrome ? 1 : 0, lengthCaracteresEspeciales);
        } catch (Exception e) {
            throw new PalindromeProcessingException("Ocurrió un error al procesar la cadena.", e);
        }
    }





}
