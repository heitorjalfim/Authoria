package com.biblioteca.gestao_livros.api.dto;

import com.biblioteca.gestao_livros.domain.*;
import lombok.Data;

@Data
public class AutorResponseDTO {
    public Long id;
    public String nome;
    public String nacionalidade;

    public AutorResponseDTO(Autor autor){
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.nacionalidade = autor.getNacionalidade();
    }
}
