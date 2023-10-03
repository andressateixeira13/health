package com.example.health.service;

import com.example.health.model.cirurgia.Cirurgia;
import com.example.health.model.cirurgia.CirurgiaRepository;
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

    public Cirurgia atualizarCirurgia(Long id, Cirurgia cirurgiaAtualizada) {
        Optional<Cirurgia> cirurgiaExistente = cirurgiaRepository.findById(id);

        if (cirurgiaExistente.isPresent()) {
            Cirurgia cirurgia = cirurgiaExistente.get();
            cirurgia.setIdPac(cirurgiaAtualizada.getIdPac());
            cirurgia.setIdMed(cirurgiaAtualizada.getIdMed());
            cirurgia.setNome(cirurgiaAtualizada.getNome());
            cirurgia.setDescricao(cirurgiaAtualizada.getDescricao());

            return cirurgiaRepository.save(cirurgia);
        }

        return null; // Ou você pode lançar uma exceção ou retornar algo que indique que não foi encontrado
    }

    public void excluirCirurgia(Long id) {
        cirurgiaRepository.deleteById(id);
    }
}
