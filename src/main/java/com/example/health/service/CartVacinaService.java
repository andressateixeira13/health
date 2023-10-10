package com.example.health.service;

import com.example.health.model.cartVacina.CartVacina;
import com.example.health.model.cartVacina.CartVacinaRepository;
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

    public CartVacina atualizarCartVacina(Long id, CartVacina cartVacinaAtualizada) {
        Optional<CartVacina> cartVacinaExistente = cartVacinaRepository.findById(id);

        if (cartVacinaExistente.isPresent()) {
            CartVacina cartVacina = cartVacinaExistente.get();
            cartVacina.setIdpac(cartVacinaAtualizada.getIdpac());
            cartVacina.setNome(cartVacinaAtualizada.getNome());
            cartVacina.setDataAplic(cartVacinaAtualizada.getDataAplic());

            return cartVacinaRepository.save(cartVacina);
        }

        return null; // Ou você pode lançar uma exceção ou retornar algo que indique que não foi encontrado
    }

    public void excluirCartVacina(Long id) {
        cartVacinaRepository.deleteById(id);
    }
}
