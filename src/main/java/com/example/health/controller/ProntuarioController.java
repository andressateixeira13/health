package com.example.health.controller;

import com.example.health.model.prontuario.Prontuario;
import com.example.health.service.ProntuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {
    private final ProntuarioService prontuarioService;

    @Autowired
    public ProntuarioController(ProntuarioService prontuarioService) {
        this.prontuarioService = prontuarioService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Prontuario>> listarProntuarios() {
        List<Prontuario> prontuarios = prontuarioService.listarProntuarios();
        return ResponseEntity.ok(prontuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prontuario> buscarProntuarioPorId(@PathVariable Long id) {
        Optional<Prontuario> prontuario = prontuarioService.buscarProntuarioPorId(id);

        if (prontuario.isPresent()) {
            return ResponseEntity.ok(prontuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Prontuario> salvarProntuario(@RequestBody @Valid Prontuario prontuario,
                                                       UriComponentsBuilder uriBuilder) {
        Prontuario savedProntuario = prontuarioService.salvarProntuario(prontuario);

        if (savedProntuario != null) {
            URI uri = uriBuilder.path("/prontuarios/{id}").buildAndExpand(savedProntuario.getId()).toUri();
            return ResponseEntity.created(uri).body(savedProntuario);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prontuario> atualizarProntuario(@PathVariable Long id,
                                                          @RequestBody Prontuario prontuarioAtualizado) {
        Prontuario updatedProntuario = prontuarioService.atualizarProntuario(id, prontuarioAtualizado);

        if (updatedProntuario != null) {
            return ResponseEntity.ok(updatedProntuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProntuario(@PathVariable Long id) {
        prontuarioService.excluirProntuario(id);
        return ResponseEntity.noContent().build();
    }
}
