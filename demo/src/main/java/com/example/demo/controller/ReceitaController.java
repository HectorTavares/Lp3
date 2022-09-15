package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/receita")
public class ReceitaController {

    @GetMapping()
    public String teste(){
        return "Teste";
    }



}
