package com.example.demo.repository;

import com.example.demo.domain.Ingrediente;
import com.example.demo.domain.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findByIngredientesContains(Ingrediente ingrediente);

}
