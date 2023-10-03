package com.example.health.controller;

import com.example.health.model.consulta.Consulta;
import com.example.health.model.consulta.ConsultaDTO;
import com.example.health.model.paciente.Paciente;
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
        //monta a URI da aplicação dinamicamente
        URI uri = uriBuilder.path("/consulta/{id}").buildAndExpand(consulta.getId()).toUri();
        //created(uri) irá colocar no cabeçalho da requisição da resposta
        // o parâmetro Location com a URI de acesso ao recurso criado
        return ResponseEntity.created(uri).body(consulta);
    }


    @GetMapping
    public ResponseEntity<List<Consulta>> listar(){
        return ResponseEntity.ok(this.service.listar());
    }


    /*
     ATUALIZAR DEVE DEVOLVER O RECURSO ATUALIZADO
     Mas não é boa prática devolver a entidade JPA no controler;

    * */
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

    @PutMapping("/{id}/atribuir-projeto")
    @Transactional
    public ResponseEntity vincularProjeto(@PathVariable Long id, @RequestBody Paciente paciente){
        return ResponseEntity.ok(this.service.atribuirPaciente(id, paciente));
    }

    @GetMapping("/projeto/{id}")
    public List<ConsultaDTO> listarAlunos(@PathVariable int id){
        return this.service.findByConsultaPorPaciente(id);
    }

}

