package com.example.health.service;

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

    public Exame atualizarExame(Long id, Exame exameAtualizado) {
        Optional<Exame> exameExistente = exameRepository.findById(id);

        if (exameExistente.isPresent()) {
            Exame exame = exameExistente.get();
            exame.setNome(exameAtualizado.getNome());
            exame.setDescricao(exameAtualizado.getDescricao());
            exame.setFileData(exameAtualizado.getFileData());

            return exameRepository.save(exame);
        }

        return null;
    }

    public void excluirExame(Long id) {
        exameRepository.deleteById(id);
    }

    public List<Exame> findByExamePorPaciente(int id){
        return this.exameRepository.findExameByPaciente(id);
    }
}
