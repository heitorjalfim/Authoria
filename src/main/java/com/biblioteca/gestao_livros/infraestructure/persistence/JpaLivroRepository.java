package com.biblioteca.gestao_livros.infraestructure.persistence;

import com.biblioteca.gestao_livros.domain.*;
import org.springframework.stereotype.Repository;
import java.util.*;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JpaLivroRepository implements ILivroRepository{
    private final SpringDataLivroRepository springDataRepoLivro;
    private final SpringDataAutorRepository springDataRepoAutor;

    @Override
    public Optional<Livro> findById(Long id){
        Optional<LivroEntity> livroEntity = springDataRepoLivro.findById(id);
        return livroEntity.map(entity -> {
            AutorEntity autorEntity = entity.getAutor();
            Autor autorDominio = new Autor
            (autorEntity.getId(), autorEntity.getNome(), autorEntity.getNacionalidade(), autorEntity.getRenda());
            Livro livroDominio = new Livro(entity.getTitulo(), entity.getAno(), entity.getValor());
            livroDominio.setAutor(autorDominio);
            livroDominio.setId(entity.getId());
            return livroDominio;
        });
    }

    @Override
    public void salvar(Livro livro){
        LivroEntity novoLivro = new LivroEntity();
        novoLivro.setAno(livro.getAno());
        novoLivro.setStatus(StatusLivro.DISPONIVEL);
        novoLivro.setTitulo(livro.getTitulo());
        novoLivro.setValor(livro.getValor());

        AutorEntity autor = springDataRepoAutor.findById(livro.getAutor().getId()).orElseThrow(
            () -> new IllegalStateException("Autor ja deveria existir"));
        novoLivro.setAutor(autor);

        springDataRepoLivro.save(novoLivro);
    }

    @Override
    public void remover(Long id){
        springDataRepoLivro.deleteById(id);
    }
}
