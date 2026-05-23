package com.biblioteca.gestao_livros.infraestructure.persistence;

import com.biblioteca.gestao_livros.domain.AutorRepository;

import lombok.RequiredArgsConstructor;

import com.biblioteca.gestao_livros.domain.Autor;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaAutorRepository implements AutorRepository {
    private final SpringDataAutorRepository autorRepo;

    public Optional<Autor> findById(Long id){
        Optional<AutorEntity> autorEntity = autorRepo.findById(id);
        return autorEntity.map(entity -> {
            Autor autor = new Autor(entity.getNome());
            autor.setNacionalidade(entity.getNacionalidade());

            
        })
    }
}
