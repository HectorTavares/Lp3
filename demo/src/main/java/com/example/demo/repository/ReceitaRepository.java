package com.example.demo.repository;

import com.example.demo.domain.Categoria;
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

    @Query(value = "select distinct * from receita r inner join receita_ingrediente ri on r.id = ri.receita_id  where ri.ingrediente_id in (:ingredientes)", nativeQuery = true)
    List<Receita> findByIngredientes(List<Long> ingredientes);

    @Query(value = "select * from receita r where r.categoria in (:categorias)", nativeQuery = true)
    List<Receita> findByCategorias(List<String> categorias);

    @Query(value = " select * from receita r where r.modo_preparo LIKE %:palavraChave% ", nativeQuery = true)
    List<Receita> findByModoPreparo(String palavraChave);
}
