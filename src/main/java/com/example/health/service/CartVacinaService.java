package com.example.health.service;

import com.example.health.model.cartVacina.CartVacina;
import com.example.health.model.cartVacina.CartVacinaRepository;
import com.example.health.model.consulta.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CartVacinaService {
    private final CartVacinaRepository cartVacinaRepository;

    @Autowired
    public CartVacinaService(CartVacinaRepository cartVacinaRepository) {
        this.cartVacinaRepository = cartVacinaRepository;
    }

    public List<CartVacina> listarCartVacina() {
        return cartVacinaRepository.findAll();
    }

    public Optional<CartVacina> buscarCartVacinaPorId(Long id) {
        return cartVacinaRepository.findById(id);
    }

    public CartVacina salvarCartVacina(CartVacina cartVacina) {
        return cartVacinaRepository.save(cartVacina);
    }

    public void atualizar(CartVacina cartVacina){
        CartVacina a = this.cartVacinaRepository.getReferenceById(cartVacina.getIdvac());
        a.setNome(cartVacina.getNome());
        a.setDataAplic(cartVacina.getDataAplic());
    }

    public void excluirCartVacina(Long id) {
        cartVacinaRepository.deleteById(id);
    }
}
