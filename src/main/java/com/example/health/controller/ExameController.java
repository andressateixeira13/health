package com.example.health.controller;

import com.example.health.model.exame.Exame;
import com.example.health.model.exame.ExameDTO;
import com.example.health.service.ExameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exames")
public class ExameController {
    private final ExameService exameService;

    @Autowired
    public ExameController(ExameService exameService) {
        this.exameService = exameService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Exame>> listarExames() {
        List<Exame> exames = exameService.listarExames();
        return ResponseEntity.ok(exames);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exame> buscarExamePorId(@PathVariable Long id) {
        Optional<Exame> exame = exameService.buscarExamePorId(id);

        if (exame.isPresent()) {
            return ResponseEntity.ok(exame.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity salvarExame(@RequestBody @Valid Exame exame, UriComponentsBuilder uriBuilder) {
        this.exameService.salvarExame(exame);
        URI uri = uriBuilder.path("/exames/{id}").buildAndExpand(exame.getIdexame()).toUri();
        return ResponseEntity.created(uri).body(exame);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Exame exame){
        this.exameService.atualizar(exame);
        return ResponseEntity.ok(exame);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirExame(@PathVariable Long id) {
        exameService.excluirExame(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exames/{id}")
    public List<ExameDTO> listarExames(@PathVariable int id){
        return this.exameService.findByExamePorPaciente(id);
    }
}
