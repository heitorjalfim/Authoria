package com.biblioteca.gestao_livros.domain;

import lombok.*;

@Getter
public class Livro {
    private Long id;
    private Long idAutor;
    private String titulo;
    private int ano;
    private double valor;
    private StatusLivro status;

    public Livro(String titulo, int ano, double valor, Long idAutor){
        validar(titulo, ano, valor, idAutor);
        this.idAutor = idAutor;
        this.titulo = titulo;
        this.ano = ano;
        this.valor = valor;
        this.status = StatusLivro.DISPONIVEL;
    }

    public Livro(Long id, Long idAutor, String titulo, int ano, Double valor, StatusLivro status) {
        this.id = id;
        this.idAutor = idAutor;
        this.titulo = titulo;
        this.ano = ano;
        this.valor = valor;
        this.status = status;
    }

    public void validar(String titulo, int ano, Double valor, Long idAutor){
        if (titulo == null || titulo.isBlank() || titulo.length() < 1) {
            throw new IllegalArgumentException("Titulo invalido");
        }
        if (ano < 0) {
            throw new IllegalArgumentException("Ano invalido");
        }
        if (valor == null || valor <= 0) {
            throw new IllegalArgumentException("Valor invalido");
        }
        if (idAutor == null || idAutor <= 0) {
            throw new IllegalArgumentException("Valor invalido");
        }
    }

    public void emprestar(){
        if (this.status == StatusLivro.EMPRESTADO || this.status == StatusLivro.VENDIDO) {
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
        }
        else{
            throw new RuntimeException("Livro não disponivel");
        }
    }
}
