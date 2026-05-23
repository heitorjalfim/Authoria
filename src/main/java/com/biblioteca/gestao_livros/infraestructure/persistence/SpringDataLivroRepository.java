package com.biblioteca.gestao_livros.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataLivroRepository extends JpaRepository<LivroEntity, Long>{
}
