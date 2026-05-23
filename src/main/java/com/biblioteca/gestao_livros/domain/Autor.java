package com.biblioteca.gestao_livros.domain;

import java.util.*;

import lombok.Getter;

@Getter
public class Autor {
    private long id;
    private List<Livro> livros = new ArrayList<>();
    private String nome;
    private String nacionalidade;
    private double renda;

    public Autor(String nome){
        validar(nome, nacionalidade);
        this.nome = nome;
    }

    public Autor(String nome, String nacionalidade, List<Livro> livros, double renda){
        validarRendaArray(nome, 
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
        if (n.isBlank() || n.equals(null)) {
            throw new IllegalArgumentException("Nacionalidade invalida");
        }
        this.nacionalidade = n;
    }

    public void setRenda(Long r){
        if (r < 0 || r > this.renda) {
            
        }
    }
}
