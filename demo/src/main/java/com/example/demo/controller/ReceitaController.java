package com.example.demo.controller;

import com.example.demo.domain.Receita;
import com.example.demo.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    ReceitaService service;

    @GetMapping("/teste")
    public String teste(){
        return "Teste";
    }

    @GetMapping()
    public List<Receita> buscarReceitaPorNomeDeIngrediente(@RequestParam String nomeIngrediente){
        return service.buscarReceitaPorIngrediente(nomeIngrediente);
    }


}
