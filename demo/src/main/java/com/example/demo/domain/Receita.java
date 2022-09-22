package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "receita")

public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;

    private Double somaNotas;

    private Integer numNotas;

    private String modoPreparo;

    private Categoria categoria;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "receita_ingrediente",
            joinColumns = @JoinColumn(
                    name = "receita_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "ingrediente_id", referencedColumnName = "id"
            )
    )
    private List<Ingrediente>  ingredientes;

}
