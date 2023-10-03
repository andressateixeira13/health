package com.example.health.model.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    public Consulta getById(Long id);
    public Optional<Consulta> findById(Long id);

    @Query(value = "SELECT c.id as idCon, c.idPac as idPac, c.dataCon as dataCon," +
            " c.motivo as motivo, c.diagnostico as diagnostico, c.tratamento as tratamento," +
            "c.prescricao as prescricao FROM consultas WHERE c.idCon =:id", nativeQuery = true)
    List<ConsultaDTO> findConsultaByPaciente(@Param("id") int id);

}
