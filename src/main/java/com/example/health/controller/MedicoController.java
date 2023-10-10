package com.example.health.controller;

import com.example.health.model.medico.Medico;
import com.example.health.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/{id}")
    public Medico buscarPorId(@PathVariable Long id) {
       return this.medicoService.findById(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<Medico>> listarTodos() {
        List<Medico> medicos = medicoService.listarTodos();
        return ResponseEntity.ok(medicos);
    }

    @PostMapping("/")
    /*public ResponseEntity<Medico> salvarMedico(@RequestBody @Valid Medico medico) {
        Medico savedMedico = medicoService.salvarMedico(medico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedMedico.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedMedico);
    }*/

    @PutMapping("/{id}")
    public ResponseEntity atualizarMedico(@RequestBody Medico medico) {
        this.medicoService.atualizarMedico(medico);
        return ResponseEntity.ok(medico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMedico(@PathVariable Long id) {
        medicoService.excluirMedico(id);
        return ResponseEntity.noContent().build();
    }
}
