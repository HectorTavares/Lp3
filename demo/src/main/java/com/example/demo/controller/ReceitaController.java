package com.example.demo.controller;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Ingrediente;
import com.example.demo.domain.Receita;
import com.example.demo.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController()
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    ReceitaService service;

    @GetMapping()
    public List<Receita> buscarReceitaPorNomeDeIngrediente(@RequestParam String nomeIngrediente){
        return service.buscarReceitaPorIngrediente(nomeIngrediente);
    }

    @GetMapping("/nota")
    public List<Receita> buscarReceitasPorIntervaloDeNotas(@RequestParam double notaMinima, @RequestParam double notaMaxima){
        return service.buscarReceitaPorIntervaloDeNotas(notaMinima, notaMaxima);
    }

    @GetMapping("/ingredientes")
    public List<Receita> buscarReceitasPorIngredientesEspecificos(@RequestParam String[] ingredientes){
        return service.buscarTodasReceitasQuePossuamIngredientes(ingredientes);
    }

    @GetMapping("/categorias/ingredientes")
    public HashMap<Categoria, List<Ingrediente>> buscarReceitasPorIngredientesEspecificos(){
        return service.buscarIngredientesPorCategoria();
    }

    @GetMapping("/categorias")
    public List<Receita>listarReceitasPorCategorias(@RequestParam String[] categorias){
        return service.buscarReceitasPorCategoria(categorias);
    }


    @GetMapping("/preparo")
    public List<Receita> listarTodasAsReceitasPorOcorrenciaDePalavraChaveNoModoDePreparo(@RequestParam String palavraChave){
        return service.buscarPorPalavraChave(palavraChave);
    }

}
