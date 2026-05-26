package com.biblioteca.gestao_livros.infraestructure.persistence;

import com.biblioteca.gestao_livros.domain.IAutorRepository;
import lombok.RequiredArgsConstructor;
import com.biblioteca.gestao_livros.domain.Autor;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaAutorRepository implements IAutorRepository {
    private final SpringDataAutorRepository autorRepo;

    public Optional<Autor> findById(Long id){
        return autorRepo.findById(id).map(entity -> {
            return new Autor(id, entity.getNome(), entity.getNacionalidade(), entity.getRenda());
        });
    }

    public void salvar(Autor autor){
        AutorEntity novoAutor = new AutorEntity();
        novoAutor.setNacionalidade(autor.getNacionalidade());
        novoAutor.setNome(autor.getNome());
        autorRepo.save(novoAutor);
    }

    public void remover(Long id){
        autorRepo.deleteById(id);
    }
}
