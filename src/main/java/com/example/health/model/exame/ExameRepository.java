package com.example.health.model.exame;

import com.example.health.model.consulta.ConsultaDTO;
import com.example.health.model.exame.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ExameRepository extends JpaRepository<Exame, Long> {
    public Exame getById(Long id);

    public Optional<Exame> findById(Long id);

    @Query(value = "SELECT  p.nome, e.descricao, e.file_data " +
            "FROM exames e, paciente p WHERE e.idexame =:id AND p.idpac=:e.idpac", nativeQuery = true)
    List<ExameDTO> findExameByPaciente(@Param("id") int id);

}