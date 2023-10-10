package com.example.health.model.medico;

import com.example.health.model.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    public Medico getById(Long id);

    public Optional<Medico> findById(Long id);

    /*melhorar @Query*/
    @Query(value = "SELECT m.id as idMed, m.nome as nome, m.especialidade as especialidade, m.crm as crm," +
            " FROM Medico m WHERE m.especialidade =:especialidade", nativeQuery = true)
            List<Medico> findByEspecialidade(String especialidade);
}

