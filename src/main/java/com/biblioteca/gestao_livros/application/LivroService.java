package com.biblioteca.gestao_livros.application;

import org.springframework.stereotype.Service;
import com.biblioteca.gestao_livros.domain.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final ILivroRepository livroRepo;

    public void vender(Long id){
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id invalido");
        }
        Livro livro = livroRepo.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Livro nao encontrado"));
        livro.vender();
        livroRepo.salvar(livro);
    }

    public void devolver(Long id){
        if (id < 0 || id == null) {
            throw new IllegalArgumentException("Id invalido");
        }
        Livro livro = livroRepo.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Livro nao encontrado"));
        livro.devolver();
        livroRepo.salvar(livro);
    }

    public void emprestar(Long id){
        if (id < 0 || id == null) {
            throw new IllegalArgumentException("Id invalido");
        }
        Livro livro = livroRepo.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Livro nao encontrado"));
        livro.emprestar();
        livroRepo.salvar(livro);
    }


    public void remover(Long id){
        if (id == null || id < 0) {
            throw new IllegalArgumentException("ID invalido");
        }
        livroRepo.remover(id);
    }

    public Livro findById(Long id){
        if (id == null || id < 0) {
           throw new IllegalArgumentException("ID invalido"); 
        }
        return livroRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Livro nao encontrado"));
    }

    
}
