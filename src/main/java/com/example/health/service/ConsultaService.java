package com.example.health.service;

import com.example.health.model.consulta.Consulta;
import com.example.health.model.consulta.ConsultaDTO;
import com.example.health.model.consulta.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    private ConsultaRepository repository;
    @Autowired
    public ConsultaService(ConsultaRepository repository){
        this.repository = repository;
    }

    public void salvar(Consulta consulta){
        this.repository.save(consulta);
    }
    public List<Consulta> listar(){
        return this.repository.findAll();
    }

    public void atualizar(Consulta consulta){
        Consulta a = this.repository.getReferenceById(consulta.getIdcon());
        a.setMotivo(consulta.getMotivo());
        a.setPrescricao(consulta.getPrescricao());
        a.setDiagnostico(consulta.getDiagnostico());
        a.setTratamento(consulta.getTratamento());
    }

    public void excluir(Long id){
        this.repository.deleteById(id);
    }

    public Consulta findById(Long id){
        return this.repository.findById(id).get();
    }

    public List<ConsultaDTO> findByConsultasPorPaciente(Long id){
        return this.repository.findConsultasByPaciente(id);
    }


}