package com.example.health.service;

import com.example.health.model.consulta.Consulta;
import com.example.health.model.consulta.ConsultaDTO;
import com.example.health.model.consulta.ConsultaRepository;
import com.example.health.model.paciente.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    private ConsultaRepository repository;
    public ConsultaService(ConsultaRepository repository){
        this.repository = repository;
    }
    public void salvar(Consulta consulta){
        this.repository.save(consulta);
    }
    public List<Consulta> listar(){
        return this.repository.findAll();
    }
    public Consulta findById(Long id){
        return this.repository.findById(id).get();
    }
    /*
    Para atualizar uma entidade do banco é necessário pegar a referencia desta
    e atualizar com os dados que vieram por parametro.
    O Save detecta que é uma entidade que já existe no banco por ter um ID e dados modificados
    e faz um update
    * */
    public void atualizar(Consulta consulta){
        Consulta c = this.repository.getReferenceById(consulta.getIdcon());
        c.setPaciente(consulta.getPaciente());
        /*c.getDiagnostico(consulta.getDiagnostico());
        c.getDataCon(consulta.getDataCon());
        c.getMotivo(consulta.getMotivo());
        c.getPrescricao(consulta.getPrescricao());
        c.getTratamento(consulta.getTratamento());*/
    }
    public void excluir(Long id){
        this.repository.deleteById(id);
    }

    public String atribuirPaciente(Long idCon, Paciente paciente){
        Consulta consulta = this.repository.getReferenceById(idCon);
        consulta.setPaciente(paciente);
        return "Paciente atribuído com sucesso";
    }

    public List<ConsultaDTO> findByConsultaPorPaciente(int id){
        return this.repository.findConsultaByPaciente(id);
    }


}