package com.example.health.service;

import com.example.health.model.medico.Medico;
import com.example.health.model.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> buscarPorEspecialidade(String especialidade) {
        return medicoRepository.findByEspecialidade(especialidade);
    }

    public Medico findById(Long id){ return this.medicoRepository.findById(id).get();}

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> buscarPorId(Long id) {
        return medicoRepository.findById(id);
    }

    public Medico salvarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico atualizarMedico(Long id, Medico medicoAtualizado) {
        Optional<Medico> medicoExistente = medicoRepository.findById(id);

        if (medicoExistente.isPresent()) {
            Medico medico = medicoExistente.get();
            /*medico.setNome(medicoAtualizado.getNome());
            medico.setDataNasc(medicoAtualizado.getDataNasc());
            medico.setEspecialidade(medicoAtualizado.getEspecialidade());
            medico.setCrm(medicoAtualizado.getCrm());*/

            return medicoRepository.save(medico);
        } else {
            //throw new MedicoNotFoundException("Médico não encontrado com ID " + id);
        }
    }

    public void excluirMedico(Long id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
        } else {
           // throw new MedicoNotFoundException("Médico não encontrado com ID " + id);
        }
    }
}
}
