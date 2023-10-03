package com.example.health.controller;

import com.example.health.model.cirurgia.Cirurgia;
import com.example.health.service.CirurgiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cirurgias")
public class CirurgiaController {
    private final CirurgiaService cirurgiaService;

    @Autowired
    public CirurgiaController(CirurgiaService cirurgiaService) {
        this.cirurgiaService = cirurgiaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Cirurgia>> listarCirurgias() {
        List<Cirurgia> cirurgias = cirurgiaService.listarCirurgias();
        return ResponseEntity.ok(cirurgias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cirurgia> buscarCirurgiaPorId(@PathVariable Long id) {
        Optional<Cirurgia> cirurgia = cirurgiaService.buscarCirurgiaPorId(id);

        if (cirurgia.isPresent()) {
            return ResponseEntity.ok(cirurgia.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Cirurgia> salvarCirurgia(@RequestBody @Valid Cirurgia cirurgia,
                                                   UriComponentsBuilder uriBuilder) {
        Cirurgia savedCirurgia = cirurgiaService.salvarCirurgia(cirurgia);

        if (savedCirurgia != null) {
            URI uri = uriBuilder.path("/cirurgias/{id}").buildAndExpand(savedCirurgia.getId()).toUri();
            return ResponseEntity.created(uri).body(savedCirurgia);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cirurgia> atualizarCirurgia(@PathVariable Long id,
                                                      @RequestBody Cirurgia cirurgiaAtualizada) {
        Cirurgia updatedCirurgia = cirurgiaService.atualizarCirurgia(id, cirurgiaAtualizada);

        if (updatedCirurgia != null) {
            return ResponseEntity.ok(updatedCirurgia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCirurgia(@PathVariable Long id) {
        cirurgiaService.excluirCirurgia(id);
        return ResponseEntity.noContent().build();
    }
}