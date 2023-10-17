package com.example.health.controller;

import com.example.health.model.consulta.Consulta;
import com.example.health.model.consulta.ConsultaDTO;
import com.example.health.model.paciente.Paciente;
import com.example.health.model.prontuario.Prontuario;
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
    public ResponseEntity<Consulta> atualizar(@PathVariable Long id,
                                                          @RequestBody Consulta consultaAtualizado) {
        Consulta updatedConsulta = service.atualizar(id, consultaAtualizado);

        if (updatedConsulta != null) {
            return ResponseEntity.ok(updatedConsulta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/consultar/{id}")
    public List<ConsultaDTO> listarConsultas(@PathVariable Long id){
        return this.service.findByConsultaPorPaciente(id);
    }

}

