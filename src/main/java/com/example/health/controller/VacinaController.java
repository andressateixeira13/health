package com.example.health.controller;

import com.example.health.model.consulta.ConsultaDTO;
import com.example.health.model.vacina.Vacina;
import com.example.health.model.vacina.VacinaDTO;
import com.example.health.service.VacinaService;
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
@RequestMapping("/vacina")
public class VacinaController {
    private final VacinaService vacinaService;

    @Autowired
    public VacinaController(VacinaService vacinaService) {
        this.vacinaService = vacinaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Vacina>> listarVacina() {
        List<Vacina> vacina = vacinaService.listarVacina();
        return ResponseEntity.ok(vacina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacina> buscarVacinaPorId(@PathVariable Long id) {
        Optional<Vacina> vacina = vacinaService.buscarVacinaPorId(id);

        if (vacina.isPresent()) {
            return ResponseEntity.ok(vacina.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Vacina> salvarVacina(@RequestBody @Valid Vacina vacina,
                                                   UriComponentsBuilder uriBuilder) {
        Vacina savedVacina = vacinaService.salvarVacina(vacina);

        if (savedVacina != null) {
            URI uri = uriBuilder.path("/vacina/{id}").buildAndExpand(savedVacina.getIdvac()).toUri();
            return ResponseEntity.created(uri).body(savedVacina);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Vacina vacina){
        this.vacinaService.atualizar(vacina);
        return ResponseEntity.ok(vacina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVacina(@PathVariable Long id) {
        vacinaService.excluirVacina(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paciente/{id}")
    public List<VacinaDTO> listarConsultasPorPaciente(@PathVariable Long id){
        return this.vacinaService.findByVacinasPorPaciente(id);
    }
}
