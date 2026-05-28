package com.biblioteca.gestao_livros.api;

import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.gestao_livros.api.dto.LivroResponseDTO;
import com.biblioteca.gestao_livros.application.LivroService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {
    private final LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> getLivro(@PathVariable Long id) {
        var livro = livroService.findById(id);
        LivroResponseDTO livroDto = new LivroResponseDTO(livro);
        return ResponseEntity.ok(livroDto);
    }

    @PatchMapping("/{id}/vender")
    public ResponseEntity<Void> vender(@PathVariable Long id){
        livroService.vender(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/devolver")
    public ResponseEntity<Void> devolver(@PathVariable Long id){
        livroService.devolver(id);
        return ResponseEntity.ok().build();
    }
    
    @PatchMapping("/{id}/emprestar")
    public ResponseEntity<Void> emprestar(@PathVariable Long id){
        livroService.emprestar(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        livroService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
