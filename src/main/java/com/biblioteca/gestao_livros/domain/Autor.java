package com.biblioteca.gestao_livros.domain;

import java.util.*;

import lombok.Getter;

@Getter
public class Autor {
    private Long id;
    private List<Livro> livros = new ArrayList<>();
    private String nome;
    private String nacionalidade;
    private Double renda;

    public Autor(String nome, String nacionalidade){
        validar(nome, nacionalidade);
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.renda = 0.0;
    }

    public Autor(Long id, String nome, String nacionalidade, Double renda) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.renda = renda;
    }

    public void validar(String nome, String nacionalidade){
        if (nome.isEmpty() || nome.isBlank() || nome.length() < 2) {
            throw new IllegalArgumentException("Nome invalido");
        }
        if (nacionalidade.isEmpty() || nacionalidade.isBlank() || nacionalidade.length() < 2) {
            throw new IllegalArgumentException("Nacionalidade invalida");
        }
    }

    public void gerarDeposito(double valor){
        this.renda += valor;
    }

    public void publicar(Livro livro){
        if (livro == null) {
            throw new IllegalArgumentException("Livro nao encontrado");
        }
        livro.setAutor(this);
        this.livros.add(livro);
    }

    public void setNacionalidade(String n){
        if (n.equals(null) || n.isBlank()) {
            throw new IllegalArgumentException("Nacionalidade invalida");
        }
        this.nacionalidade = n;
    }
}
