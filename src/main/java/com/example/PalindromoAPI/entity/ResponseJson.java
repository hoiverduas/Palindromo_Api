package com.example.PalindromoAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseJson {

    private int lengthCadena;
    private int isPalindromo;
    private int lengthCaracteresEspeciales;

}
