package com.example.demo.repository;

import com.example.demo.domain.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    Ingrediente findFirstByNome(String nome);

}
