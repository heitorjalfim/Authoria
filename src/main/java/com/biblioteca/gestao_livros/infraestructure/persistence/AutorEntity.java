package com.biblioteca.gestao_livros.infraestructure.persistence;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class AutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<LivroEntity> livros = new ArrayList<>();
    private String nome;
    private String nacionalidade;
    private Double renda = 0.0;
}
