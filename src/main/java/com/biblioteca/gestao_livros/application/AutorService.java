package com.biblioteca.gestao_livros.application;

import org.springframework.stereotype.Service;
import com.biblioteca.gestao_livros.domain.Autor;
import com.biblioteca.gestao_livros.domain.IAutorRepository;
import com.biblioteca.gestao_livros.domain.Livro;
import com.biblioteca.gestao_livros.domain.ILivroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutorService {
    private final IAutorRepository autorRepo;
    private final ILivroRepository livroRepo;

    public Autor findbyid(Long id){
        if (id < 0 || id == null) {
            throw new IllegalArgumentException("Id invalido");
        }
        return autorRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Autor nao encontrado"));
    }

    public void salvar(String nome, String nacionalidade){
        Autor novoAutor = new Autor(nome, nacionalidade);
        autorRepo.salvar(novoAutor);
    }

    public void deletar(Long id){
        if (id < 0 || id == null) {
            throw new IllegalArgumentException("ID invalido");
        }
        autorRepo.remover(id);
    }

    public void publicar(Long autorId, String titulo, int ano, double valor){
        Autor autor = autorRepo.findById(autorId).orElseThrow(
            () -> new IllegalArgumentException("Id nao encontrado"));
        Livro novoLivro = new Livro(titulo, ano, valor);
        autor.publicar(novoLivro);
        livroRepo.salvar(novoLivro);
    }

}
