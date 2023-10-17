package com.example.health.service;

import com.example.health.model.cirurgia.Cirurgia;
import com.example.health.model.cirurgia.CirurgiaRepository;
import com.example.health.model.consulta.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CirurgiaService {
    private final CirurgiaRepository cirurgiaRepository;

    @Autowired
    public CirurgiaService(CirurgiaRepository cirurgiaRepository) {
        this.cirurgiaRepository = cirurgiaRepository;
    }

    public List<Cirurgia> listarCirurgias() {
        return cirurgiaRepository.findAll();
    }

    public Optional<Cirurgia> buscarCirurgiaPorId(Long id) {
        return cirurgiaRepository.findById(id);
    }

    public Cirurgia salvarCirurgia(Cirurgia cirurgia) {
        return cirurgiaRepository.save(cirurgia);
    }

    public void atualizar(Cirurgia cirurgia){
        Cirurgia a = this.cirurgiaRepository.getReferenceById(cirurgia.getIdcirurgia());
        a.setNome(cirurgia.getNome());
        a.setDescricao(cirurgia.getDescricao());
    }

    public void excluirCirurgia(Long id) {
        cirurgiaRepository.deleteById(id);
    }
}
