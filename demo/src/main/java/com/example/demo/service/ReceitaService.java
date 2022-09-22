package com.example.demo.service;

import com.example.demo.domain.Ingrediente;
import com.example.demo.domain.Receita;
import com.example.demo.repository.IngredienteRepository;
import com.example.demo.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
