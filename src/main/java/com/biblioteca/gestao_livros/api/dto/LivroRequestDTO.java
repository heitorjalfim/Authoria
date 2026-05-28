package com.biblioteca.gestao_livros.api.dto;
import lombok.Data;

@Data
public class LivroRequestDTO {
    public String titulo;
    public int anoLancamento;
    public double valor;
}
