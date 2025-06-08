package com.filmes.demo.controller;

import com.filmes.demo.DTO.FilmesDTO;
import com.filmes.demo.service.FilmesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@CrossOrigin(origins = "*") // Caso esteja consumindo via frontend local
public class FilmesController {

    private final FilmesService filmesService;

    public FilmesController(FilmesService filmesService) {
        this.filmesService = filmesService;
    }

    // ✅ Salvar novo filme (com imagem em base64)
    @PostMapping
    public ResponseEntity<FilmesDTO> salvar(@RequestBody FilmesDTO filmesDTO) {
        FilmesDTO salvo = filmesService.save(filmesDTO);
        return ResponseEntity.status(201).body(salvo);
    }

    // ✅ Buscar filme por ID
    @GetMapping("/{id}")
    public ResponseEntity<FilmesDTO> findById(@PathVariable Long id) {
        FilmesDTO dto = filmesService.findById(id);
        return ResponseEntity.ok(dto);
    }

    // ✅ Listar todos os filmes
    @GetMapping("/listar")
    public ResponseEntity<List<FilmesDTO>> listarTodos() {
        List<FilmesDTO> filmes = filmesService.findAll();
        return ResponseEntity.ok(filmes);
    }

    // ✅ Atualizar filme por ID
    @PutMapping("/{id}")
    public ResponseEntity<FilmesDTO> atualizar(@PathVariable Long id, @RequestBody FilmesDTO filmesDTO) {
        FilmesDTO atualizado = filmesService.updateById(id, filmesDTO);
        return ResponseEntity.ok(atualizado);
    }

    // ✅ Deletar filme por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        filmesService.deleteById(id);
        return ResponseEntity.ok("Filme removido com sucesso!");
    }
}
