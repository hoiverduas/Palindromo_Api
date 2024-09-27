package com.example.PalindromoAPI.service;

import com.example.PalindromoAPI.entity.ResponseJson;
import com.example.PalindromoAPI.exception.PalindromeInputException;
import com.example.PalindromoAPI.exception.PalindromeProcessingException;

public interface IPalindromeService {

    ResponseJson checkPalindrome(String palindromo) throws PalindromeInputException, PalindromeProcessingException;
}
