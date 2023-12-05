package com.example.health.model.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    public Consulta getById(Long id);
    public Optional<Consulta> findById(Long id);

    @Query(value = "SELECT  p.nome, p.datanasc, p.genero ,c.datacon as datacon," +
            " c.motivo as motivo, c.diagnostico as diagnostico, c.tratamento as tratamento," +
            "c.prescricao as prescricao FROM consultas c, paciente p WHERE c.idpac=:id AND p.idpac=:id", nativeQuery = true)
    List<ConsultaDTO> findConsultasByPaciente(@Param("id") Long id);


}
