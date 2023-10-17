package com.example.health.model.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    public Consulta getById(Long id);
    public Optional<Consulta> findById(Long id);

    @Query(value = "SELECT c.idpac as idpac, c.idcon as idcon, c.datacon as datacon," +
            " c.motivo as motivo, c.diagnostico as diagnostico, c.tratamento as tratamento," +
            "c.prescricao as prescricao FROM consultas c WHERE c.idpac=:id ", nativeQuery = true)
    List<ConsultaDTO> findConsultaByPaciente(@Param("id") Long id);

    /*arrumar consulta*/

}
