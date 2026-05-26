package com.biblioteca.gestao_livros.infraestructure.persistence;

import com.biblioteca.gestao_livros.domain.StatusLivro;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class LivroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorEntity autor;
    
    private String titulo;
    private int ano;
    private double valor;

    @Enumerated(EnumType.STRING)
    private StatusLivro status;
}
