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

    @Query(value = "SELECT * FROM receita r WHERE (r.soma_notas / r.num_notas) >= :notaMinima AND (r.soma_notas  / r.num_notas) <= :notaMaxima", nativeQuery = true)
    List<Receita> findByNotas(double notaMinima, double notaMaxima);

//    @Query("SELECT * FROM Receita r WHERE r. IN (1, 2, 3, 4) AND somecolumnt IN :ingredientes")
//    List<Receita> findByIngredientesEquals(List<Ingrediente> ingredientes);

}
