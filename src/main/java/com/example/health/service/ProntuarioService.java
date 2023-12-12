package com.example.health.service;

import com.example.health.model.cirurgia.CirurgiaDTO;
import com.example.health.model.consulta.Consulta;
import com.example.health.model.consulta.ConsultaDTO;
import com.example.health.model.paciente.Paciente;
import com.example.health.model.prontuario.Prontuario;
import com.example.health.model.prontuario.ProntuarioDTO;
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

    public void salvarProntuario(Prontuario prontuario) {
        this.prontuarioRepository.save(prontuario);
    }

    public void atualizar(Prontuario prontuario){
        Prontuario a = this.prontuarioRepository.getReferenceById(prontuario.getIdpront());
        a.setAlergias(prontuario.getAlergias());
        a.setLimitacoes(prontuario.getLimitacoes());
        a.setIdmed(prontuario.getIdmed());
    }

    public void excluirProntuario(Long id) {
        prontuarioRepository.deleteById(id);
    }

    public Prontuario findById(Long id) {
        return this.prontuarioRepository.findById(id).get();
    }

    public ProntuarioDTO findByProntuarioPorPaciente(Long id){
        return this.prontuarioRepository.findProntuarioByPaciente(id);
    }
}
