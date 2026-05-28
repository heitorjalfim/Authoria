package com.biblioteca.gestao_livros.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import com.biblioteca.gestao_livros.api.dto.LivroRequestDTO;
import com.biblioteca.gestao_livros.application.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.biblioteca.gestao_livros.api.dto.*;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {
    private final AutorService autorService;

    @PostMapping("/{id}/publicar-livro")
    public ResponseEntity<Void> publicarLivro(@RequestBody LivroRequestDTO livro, @PathVariable long id) {
        autorService.publicar(id, livro.getTitulo(), livro.getAnoLancamento(), livro.getValor());
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> criarAutor(@RequestBody AutorRequestDTO autor){
        autorService.criar(autor.getNome(), autor.getNacionalidade());
        return ResponseEntity.status(201).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<AutorResponseDTO> findById(@PathVariable Long id) {
        var autorBanco = autorService.findbyid(id);
        AutorResponseDTO autor = new AutorResponseDTO(autorBanco);
        return ResponseEntity.ok(autor);
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        autorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    
}
