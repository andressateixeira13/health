package com.example.health.service;

import com.example.health.model.paciente.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private PacienteRepository repository;
    public PacienteService(PacienteRepository repository){
        this.repository = repository;
    }
    public void salvar(Paciente paciente){
        this.repository.save(paciente);
    }


    public List<Paciente> listar(){
        return this.repository.findAll();
    }
    public void atualizar(Paciente paciente){
        Paciente a = this.repository.getReferenceById(paciente.getIdpac());
        //a.setEndereco(paciente.getEndereco());
        a.setEmail(paciente.getEmail());
    }

    public Paciente findById(Long id) {
        return this.repository.findById(id).get();
    }


    public List<PacienteDTO> findByEnderecoPorPaciente(Long id){
        return this.repository.findEnderecoPorPaciente(id);
    }

}
