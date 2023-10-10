package com.example.health.controller;

import com.example.health.model.cartVacina.CartVacina;
import com.example.health.service.CartVacinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartvacina")
public class CartVacinaController {
    private final CartVacinaService cartVacinaService;

    @Autowired
    public CartVacinaController(CartVacinaService cartVacinaService) {
        this.cartVacinaService = cartVacinaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CartVacina>> listarCartVacina() {
        List<CartVacina> cartVacina = cartVacinaService.listarCartVacina();
        return ResponseEntity.ok(cartVacina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartVacina> buscarCartVacinaPorId(@PathVariable Long id) {
        Optional<CartVacina> cartVacina = cartVacinaService.buscarCartVacinaPorId(id);

        if (cartVacina.isPresent()) {
            return ResponseEntity.ok(cartVacina.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<CartVacina> salvarCartVacina(@RequestBody @Valid CartVacina cartVacina,
                                                       UriComponentsBuilder uriBuilder) {
        CartVacina savedCartVacina = cartVacinaService.salvarCartVacina(cartVacina);

        if (savedCartVacina != null) {
            URI uri = uriBuilder.path("/cartvacina/{id}").buildAndExpand(savedCartVacina.getIdvac()).toUri();
            return ResponseEntity.created(uri).body(savedCartVacina);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartVacina> atualizarCartVacina(@PathVariable Long id,
                                                          @RequestBody CartVacina cartVacinaAtualizada) {
        CartVacina updatedCartVacina = cartVacinaService.atualizarCartVacina(id, cartVacinaAtualizada);

        if (updatedCartVacina != null) {
            return ResponseEntity.ok(updatedCartVacina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCartVacina(@PathVariable Long id) {
        cartVacinaService.excluirCartVacina(id);
        return ResponseEntity.noContent().build();
    }
}
