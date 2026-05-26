package com.biblioteca.gestao_livros.domain;

import lombok.*;

@Getter
public class Livro {
    private long id;
    private Autor autor;
    private String titulo;
    private int ano;
    private double valor;
    private StatusLivro status;

    public Livro(String titulo, int ano, double valor){
        validar(titulo, ano, valor);
        this.titulo = titulo;
        this.ano = ano;
        this.status = StatusLivro.DISPONIVEL;
    }

    public Livro(Long id, Autor autor, String titulo, int ano, Double valor) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.ano = ano;
        this.valor = valor;
        this.status = StatusLivro.DISPONIVEL;
    }

    public void validar(String titulo, int ano, double valor){
        if (titulo == null || titulo.isBlank() || titulo.length() < 1) {
            throw new IllegalArgumentException("Titulo invalido");
        }
        if (ano < 0) {
            throw new IllegalArgumentException("Ano invalido");
        }
        if (valor < 0) {
            throw new IllegalArgumentException("Valor invalido");
        }
    }

    public void emprestar(){
        if (this.status == StatusLivro.EMPRESTADO|| this.status == StatusLivro.VENDIDO) {
            throw new IllegalArgumentException("Livro ja emprestado ou vendido");
        }
        this.status = StatusLivro.EMPRESTADO;
    }

    public void devolver(){
        if (this.status == StatusLivro.DISPONIVEL || this.status == StatusLivro.VENDIDO) {
            throw new IllegalArgumentException("Livro disponivel ou vendido");
        }
        this.status = StatusLivro.DISPONIVEL;
    }

    public void vender(){
        if (this.status == StatusLivro.DISPONIVEL) {
            this.status = StatusLivro.VENDIDO;
            this.autor.gerarDeposito(this.valor);
        }
        else{
            throw new RuntimeException("Livro não disponivel");
        }
    }

    public void setAutor(Autor autor){
        if (autor == null) {
            throw new IllegalArgumentException("Autor invalido");
        }
        this.autor = autor;
    }

    public void setId(Long id){
        if (id < 0) {
            throw new IllegalArgumentException("ID invalido");
        }
        this.id = id;
    }
}
