package com.example.health.controller;

import com.example.health.model.enfermagem.Enfermagem;
import com.example.health.service.EnfermagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enfermagem")
public class EnfermagemController {
    private final EnfermagemService enfermagemService;

    @Autowired
    public EnfermagemController(EnfermagemService enfermagemService) {
        this.enfermagemService = enfermagemService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Enfermagem>> listarEnfermagem() {
        List<Enfermagem> enfermagem = enfermagemService.listarEnfermagem();
        return ResponseEntity.ok(enfermagem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enfermagem> buscarEnfermagemPorId(@PathVariable Long id) {
        Optional<Enfermagem> enfermagem = enfermagemService.buscarEnfermagemPorId(id);

        if (enfermagem.isPresent()) {
            return ResponseEntity.ok(enfermagem.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Enfermagem> salvarEnfermagem(@RequestBody @Valid Enfermagem enfermagem,
                                                       UriComponentsBuilder uriBuilder) {
        Enfermagem savedEnfermagem = enfermagemService.salvarEnfermagem(enfermagem);

        if (savedEnfermagem != null) {
            URI uri = uriBuilder.path("/enfermagem/{id}").buildAndExpand(savedEnfermagem.getId()).toUri();
            return ResponseEntity.created(uri).body(savedEnfermagem);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enfermagem> atualizarEnfermagem(@PathVariable Long id,
                                                          @RequestBody Enfermagem enfermagemAtualizada) {
        Enfermagem updatedEnfermagem = enfermagemService.atualizarEnfermagem(id, enfermagemAtualizada);

        if (updatedEnfermagem != null) {
            return ResponseEntity.ok(updatedEnfermagem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEnfermagem(@PathVariable Long id) {
        enfermagemService.excluirEnfermagem(id);
        return ResponseEntity.noContent().build();
    }
}
