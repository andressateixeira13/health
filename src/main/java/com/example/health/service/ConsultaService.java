package com.example.health.service;

import com.example.health.model.consulta.Consulta;
import com.example.health.model.consulta.ConsultaDTO;
import com.example.health.model.consulta.ConsultaRepository;
import com.example.health.model.paciente.Paciente;
import com.example.health.model.prontuario.Prontuario;
import com.example.health.model.prontuario.ProntuarioRepository;
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


    public Consulta atualizar(Long id, Consulta consultaAtualizado){

        Optional<Consulta> consultaExistente = repository.findById(id);

        if (consultaExistente.isPresent()) {
            Consulta consulta = consultaExistente.get();
            consulta.setDiagnostico(consultaAtualizado.getDiagnostico());
            consulta.setPrescricao(consultaAtualizado.getPrescricao());
            consulta.setMotivo(consultaAtualizado.getMotivo());
            consulta.setTratamento(consultaAtualizado.getTratamento());

            return repository.save(consulta);
        }

        return null;
        /*Consulta c = this.repository.getReferenceById(consulta.getIdcon());
        c.getDiagnostico(consulta.getDiagnostico());
        c.getDatacon(consulta.getDatacon());
        c.getMotivo(consulta.getMotivo());
        c.getPrescricao(consulta.getPrescricao());
        c.getTratamento(consulta.getTratamento());*/
    }
    public void excluir(Long id){
        this.repository.deleteById(id);
    }

    public Consulta findById(Long id){
        return this.repository.findById(id).get();
    }

    public List<ConsultaDTO> findByConsultaPorPaciente(Long id){
        return this.repository.findConsultaByPaciente(id);
    }


}