package com.example.health.service;

import com.example.health.model.prontuario.Prontuario;
import com.example.health.model.prontuario.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProntuarioService {
    private final ProntuarioRepository prontuarioRepository;

    @Autowired
    public ProntuarioService(ProntuarioRepository prontuarioRepository) {
        this.prontuarioRepository = prontuarioRepository;
    }

    public List<Prontuario> listarProntuarios() {
        return prontuarioRepository.findAll();
    }

    public Optional<Prontuario> buscarProntuarioPorId(Long id) {
        return prontuarioRepository.findById(id);
    }

    public Prontuario salvarProntuario(Prontuario prontuario) {
        return prontuarioRepository.save(prontuario);
    }

    public Prontuario atualizarProntuario(Long id, Prontuario prontuarioAtualizado) {
        Optional<Prontuario> prontuarioExistente = prontuarioRepository.findById(id);

        if (prontuarioExistente.isPresent()) {
            Prontuario prontuario = prontuarioExistente.get();
            prontuario.setIdPac(prontuarioAtualizado.getIdPac());
            prontuario.setIdMed(prontuarioAtualizado.getIdMed());
            prontuario.setLimitacoes(prontuarioAtualizado.getLimitacoes());
            prontuario.setAlergias(prontuarioAtualizado.getAlergias());

            return prontuarioRepository.save(prontuario);
        }

        return null; // Ou você pode lançar uma exceção ou retornar algo que indique que não foi encontrado
    }

    public void excluirProntuario(Long id) {
        prontuarioRepository.deleteById(id);
    }
}
