package com.biblioteca.gestao_livros.api.dto;
import com.biblioteca.gestao_livros.domain.Livro;
import com.biblioteca.gestao_livros.domain.StatusLivro;

import lombok.Data;

@Data
public class LivroResponseDTO {
    public Long id;
    public String titulo;
    public String nomeAutor;
    public Long idAutor;
    public int anoLancamento;
    public double valor;
    public StatusLivro status;

    public LivroResponseDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.anoLancamento = livro.getAno();
        this.valor = livro.getValor();
        this.idAutor = livro.getIdAutor();
        this.nomeAutor = livro.getAutor().getNome();
        this.status = livro.getStatus();
    }
}
