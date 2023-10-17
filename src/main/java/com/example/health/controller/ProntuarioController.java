package com.example.health.controller;

import com.example.health.model.consulta.Consulta;
import com.example.health.model.paciente.Paciente;
import com.example.health.model.prontuario.Prontuario;
import com.example.health.service.ProntuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prontuario")
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
    public Prontuario prontuario(@PathVariable Long id){return this.prontuarioService.findById(id);}



    @PostMapping
    @Transactional
    public ResponseEntity salvarProntuario(@RequestBody @Valid Prontuario prontuario, UriComponentsBuilder uriBuilder) {
        this.prontuarioService.salvarProntuario(prontuario);


        URI uri = uriBuilder.path("/prontuario/{id}").buildAndExpand(prontuario.getIdpront()).toUri();
        return ResponseEntity.created(uri).body(prontuario);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Prontuario prontuario){
        this.prontuarioService.atualizar(prontuario);
        return ResponseEntity.ok(prontuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProntuario(@PathVariable Long id) {
        prontuarioService.excluirProntuario(id);
        return ResponseEntity.noContent().build();
    }
}
