package com.example.health.controller;

import com.example.health.model.paciente.Paciente;
import com.example.health.service.PacienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private final PacienteService service;
    public PacienteController(PacienteService service){this.service = service;}
    @PostMapping("/print-json")
    public void printJSon(@RequestBody String json){System.out.println(json);}
    @GetMapping("/{id}")
    public Paciente paciente(@PathVariable Long id){return this.service.findById(id);}

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid Paciente paciente, UriComponentsBuilder uriBuilder){
        this.service.salvar(paciente);
        URI uri = uriBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(paciente);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listar(){return ResponseEntity.ok(this.service.listar());}

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Paciente paciente){
        this.service.atualizar(paciente);
        return ResponseEntity.ok(paciente);
    }


}
