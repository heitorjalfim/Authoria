package com.biblioteca.gestao_livros.domain;

import java.util.*;

public interface IAutorRepository {
    Optional<Autor> findById(Long id);
    void salvar(Autor autor);
    void remover(Long id);
}
