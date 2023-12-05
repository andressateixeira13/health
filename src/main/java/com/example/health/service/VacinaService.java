package com.example.health.service;

import com.example.health.model.consulta.ConsultaDTO;
import com.example.health.model.vacina.Vacina;
import com.example.health.model.vacina.VacinaDTO;
import com.example.health.model.vacina.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VacinaService {
    private final VacinaRepository vacinaRepository;

    @Autowired
    public VacinaService(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }

    public List<Vacina> listarVacina() {
        return vacinaRepository.findAll();
    }

    public Optional<Vacina> buscarVacinaPorId(Long id) {
        return vacinaRepository.findById(id);
    }

    public Vacina salvarVacina(Vacina vacina) {
        return vacinaRepository.save(vacina);
    }

    public void atualizar(Vacina vacina){
        Vacina a = this.vacinaRepository.getReferenceById(vacina.getIdvac());
        a.setNome(vacina.getNome());
        a.setDataAplic(vacina.getDataAplic());
    }

    public void excluirVacina(Long id) {
        vacinaRepository.deleteById(id);
    }

    public List<VacinaDTO> findByVacinasPorPaciente(Long id){
        return this.vacinaRepository.findVacinasPorPaciente(id);
    }
}
