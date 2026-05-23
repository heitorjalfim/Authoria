package com.biblioteca.gestao_livros.application;

import org.springframework.stereotype.Service;

import com.biblioteca.gestao_livros.domain.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepo;

    public void salvar(Livro livro){
        if (livro == null) {
            throw new IllegalArgumentException("O livro nao pode ser nulo");
        }
        livroRepo.salvar(livro);
    }

    public void remover(Long id){
        if (id == null || id < 0) {
            throw new IllegalArgumentException("ID invalido");
        }
        livroRepo.remover(id);
    }

    public void findById(Long id){
        if (id == null || id < 0) {
           throw new IllegalArgumentException("ID invalido"); 
        }
        livroRepo.findById(id);
    }

    
}
