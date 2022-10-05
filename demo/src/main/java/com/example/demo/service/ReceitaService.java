package com.example.demo.service;

import com.example.demo.domain.Ingrediente;
import com.example.demo.domain.Receita;
import com.example.demo.repository.IngredienteRepository;
import com.example.demo.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.IsNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class ReceitaService {

    @Autowired
    ReceitaRepository repository;

    @Autowired
    IngredienteRepository ingredienteRepository;




    public List<Receita> buscarReceitaPorIngrediente(String nomeIngrediente) {

        Ingrediente ingrediente = ingredienteRepository.findFirstByNome(nomeIngrediente);

        if (isNull(ingrediente)){
            return new ArrayList<Receita>();
        }

        return repository.findByIngredientesContains(ingrediente);
    }

    public List<Receita> buscarReceitaPorIntervaloDeNotas(double notaMinima, double notaMaxima) {
        return repository.findBySomaNotasGreaterThanEqualAndSomaNotasLessThanEqual(notaMinima, notaMaxima);
    }

    public List<Receita> buscarTodasReceitasQuePossuamIngredientes(String[] ingredientes) {

        List<String> listaIngredientes = Arrays.asList(ingredientes);

        List<Long> idsIngredientes = listaIngredientes.stream().map(ingrediente ->
                ingredienteRepository.findFirstByNome(ingrediente).getId())
                .collect(Collectors.toList());

        return repository.findByIngredientes(idsIngredientes);
    }
}
