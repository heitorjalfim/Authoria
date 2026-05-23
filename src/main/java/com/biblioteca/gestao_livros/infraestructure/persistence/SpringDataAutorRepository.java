package com.biblioteca.gestao_livros.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAutorRepository extends JpaRepository<AutorEntity, Long>{
}
