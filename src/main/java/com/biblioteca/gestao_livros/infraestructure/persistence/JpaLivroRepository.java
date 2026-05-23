package com.biblioteca.gestao_livros.infraestructure.persistence;

import com.biblioteca.gestao_livros.domain.*;
import org.springframework.stereotype.Repository;
import java.util.*;

import com.biblioteca.gestao_livros.domain.LivroRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JpaLivroRepository implements LivroRepository{
    private final SpringDataLivroRepository springDataRepoLivro;

    @Override
    public Optional<Livro> findById(Long id){
        Optional<LivroEntity> livroEntity = springDataRepoLivro.findById(id);
        return livroEntity.map(entity -> {
            Autor autorDominio = new Autor(entity.getAutor());
            Livro livroDominio = new Livro(autorDominio, entity.getTitulo(), entity.getAno(), entity.getValor());
            livroDominio.setId(entity.getId());
            return livroDominio;
        });
    }

    @Override
    public void salvar(Livro livro){
        LivroEntity novoLivro = new LivroEntity();
        //Optional<AutorEntity> =
        novoLivro.setAno(livro.getAno());
        novoLivro.setAutor(null);
        novoLivro.setStatus(StatusLivro.DISPONIVEL);
        novoLivro.setTitulo(livro.getTitulo());
        novoLivro.setValor(livro.getValor());
        springDataRepoLivro.save(novoLivro);
    }

    @Override
    public void remover(Long id){
        springDataRepoLivro.deleteById(id);
    }
}
