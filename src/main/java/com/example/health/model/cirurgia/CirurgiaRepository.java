package com.example.health.model.cirurgia;

import com.example.health.model.cirurgia.Cirurgia;
import com.example.health.model.consulta.ConsultaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CirurgiaRepository extends JpaRepository<Cirurgia, Long> {
    public Cirurgia getById(Long id);

    public Optional<Cirurgia> findById(Long id);

    /*@Query(value = "SELECT c.id as idcirurgia, c.idpac as idpac, c.idmed as idmed," +
            " c.nome as nome, c.descricao as descricao FROM consultas WHERE c.idcirurgia =:id", nativeQuery = true)
    List<ConsultaDTO> findCirurgiaByPaciente(@Param("id") int id);
*/

}
