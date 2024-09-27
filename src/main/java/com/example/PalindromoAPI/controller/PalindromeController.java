package com.example.PalindromoAPI.controller;

import com.example.PalindromoAPI.entity.RequestJson;
import com.example.PalindromoAPI.entity.ResponseJson;
import com.example.PalindromoAPI.service.impl.PalindromeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/palindromo")
public class PalindromeController {


    private final PalindromeService palindromeService;

    public PalindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @PostMapping
    public ResponseEntity<ResponseJson> checkPalindrome(@RequestBody RequestJson requestJson) {
        return ResponseEntity.status(HttpStatus.OK).body(this.palindromeService.checkPalindrome(requestJson.getPalindromo()));
    }

}