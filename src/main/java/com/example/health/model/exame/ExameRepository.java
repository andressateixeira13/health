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

    @Query(value = "SELECT c.id as idexame, c.idpac as idpac, c.descricao as descricao," +
            "c.file_data as file_data FROM exames WHERE c.idexame =:id", nativeQuery = true)
    List<Exame> findExameByPaciente(@Param("id") int id);

}