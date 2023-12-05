package com.example.health.controller;

import com.example.health.model.consulta.Consulta;
import com.example.health.model.consulta.ConsultaDTO;
import com.example.health.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    private final ConsultaService service;
    public ConsultaController(ConsultaService service){
        this.service = service;
    }
    @PostMapping("/print-json")
    public void printJSon(@RequestBody String json){
        System.out.println(json);
    }

    @GetMapping("/{id}")
    public Consulta consulta(@PathVariable Long id){
        return this.service.findById(id);
    }


    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid Consulta consulta, UriComponentsBuilder uriBuilder){

        this.service.salvar(consulta);
        URI uri = uriBuilder.path("/consulta/{id}").buildAndExpand(consulta.getIdcon()).toUri();
        return ResponseEntity.created(uri).body(consulta);
    }


    @GetMapping
    public ResponseEntity<List<Consulta>> listar(){
        return ResponseEntity.ok(this.service.listar());
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Consulta consulta){
        this.service.atualizar(consulta);
        return ResponseEntity.ok(consulta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/paciente/{id}")
    public List<ConsultaDTO> listarConsultasPorPaciente(@PathVariable Long id){
        return this.service.findByConsultasPorPaciente(id);
    }

}

