package com.example.health.service;

import com.example.health.model.paciente.Paciente;
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
        return this.prontuarioRepository.findAll();
    }

    public void salvarProntuario(Prontuario prontuario) {
        this.prontuarioRepository.save(prontuario);
    }

    public Prontuario atualizarProntuario(Long id, Prontuario prontuarioAtualizado) {
        Optional<Prontuario> prontuarioExistente = prontuarioRepository.findById(id);

        if (prontuarioExistente.isPresent()) {
            Prontuario prontuario = prontuarioExistente.get();
            prontuario.setIdpac(prontuarioAtualizado.getIdpac());
            prontuario.setIdmed(prontuarioAtualizado.getIdmed());
            prontuario.setLimitacoes(prontuarioAtualizado.getLimitacoes());
            prontuario.setAlergias(prontuarioAtualizado.getAlergias());

            return prontuarioRepository.save(prontuario);
        }

        return null;
    }

    public void excluirProntuario(Long id) {
        prontuarioRepository.deleteById(id);
    }

    public Prontuario findById(Long id) {
        return this.prontuarioRepository.findById(id).get();
    }
}
