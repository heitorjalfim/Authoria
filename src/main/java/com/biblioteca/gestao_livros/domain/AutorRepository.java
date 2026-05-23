package com.biblioteca.gestao_livros.domain;

import java.util.*;

public interface AutorRepository {
    Optional<Autor> findById(Long id);
    void salvar(Autor autor);
    void remover(Long id);
}
