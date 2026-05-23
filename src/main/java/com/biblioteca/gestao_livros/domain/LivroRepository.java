package com.biblioteca.gestao_livros.domain;

import java.util.*;

public interface LivroRepository {
    Optional<Livro> findById(Long id);
    void salvar(Livro livro);
    void remover(Long id);
}
