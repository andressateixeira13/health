package com.example.health.controller;

import com.example.health.model.medico.Medico;
import com.example.health.service.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping
    @Transactional
    public ResponseEntity salvarMedico(@RequestBody @Valid Medico medico, UriComponentsBuilder uriBuilder) {
        this.medicoService.salvarMedico(medico);
        URI uri = uriBuilder.path("/paciente/{id}").buildAndExpand(medico.getIdmed()).toUri();

        return ResponseEntity.created(uri).body(medico);
    }

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

    @GetMapping("/{especialidade}")
    public List<Medico> listarMedicosPorEspecialidade(@PathVariable String especialidade){
        return this.medicoService.buscarPorEspecialidade(especialidade);
    }

}
