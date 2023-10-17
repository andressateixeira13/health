package com.example.health.service;

import com.example.health.model.consulta.Consulta;
import com.example.health.model.consulta.ConsultaDTO;
import com.example.health.model.exame.Exame;
import com.example.health.model.exame.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExameService {
    private final ExameRepository exameRepository;

    @Autowired
    public ExameService(ExameRepository exameRepository) {
        this.exameRepository = exameRepository;
    }

    public List<Exame> listarExames() {
        return exameRepository.findAll();
    }

    public Optional<Exame> buscarExamePorId(Long id) {
        return exameRepository.findById(id);
    }

    public Exame salvarExame(Exame exame) {
        return exameRepository.save(exame);
    }

    public void atualizar(Exame exame){
        Exame a = this.exameRepository.getReferenceById(exame.getIdexame());
        a.setDescricao(exame.getDescricao());
        a.setNome(exame.getNome());
        a.setFileData(exame.getFileData());
    }

    public void excluirExame(Long id) {
        exameRepository.deleteById(id);
    }

    public List<Exame> findByExamePorPaciente(int id){
        return this.exameRepository.findExameByPaciente(id);
    }
}
