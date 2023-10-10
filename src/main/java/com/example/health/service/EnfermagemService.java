package com.example.health.service;

import com.example.health.model.enfermagem.Enfermagem;
import com.example.health.model.enfermagem.EnfermagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EnfermagemService {
    private final EnfermagemRepository enfermagemRepository;

    @Autowired
    public EnfermagemService(EnfermagemRepository enfermagemRepository) {
        this.enfermagemRepository = enfermagemRepository;
    }

    public List<Enfermagem> listarEnfermagem() {
        return enfermagemRepository.findAll();
    }

    public Optional<Enfermagem> buscarEnfermagemPorId(Long id) {
        return enfermagemRepository.findById(id);
    }

    public Enfermagem salvarEnfermagem(Enfermagem enfermagem) {
        return (Enfermagem) enfermagemRepository.save(enfermagem);
    }

    public Enfermagem atualizarEnfermagem(Long id, Enfermagem enfermagemAtualizada) {
        Optional<Enfermagem> enfermagemExistente = enfermagemRepository.findById(id);

        if (enfermagemExistente.isPresent()) {
            Enfermagem enfermagem = enfermagemExistente.get();
            enfermagem.setNome(enfermagemAtualizada.getNome());
            enfermagem.setDatanasc(enfermagemAtualizada.getDatanasc());
            enfermagem.setCargo(enfermagemAtualizada.getCargo());
            enfermagem.setCoren(enfermagemAtualizada.getCoren());

            return (Enfermagem) enfermagemRepository.save(enfermagem);
        }

        return null;
    }

    public void excluirEnfermagem(Long id) {
        enfermagemRepository.deleteById(id);
    }
}
