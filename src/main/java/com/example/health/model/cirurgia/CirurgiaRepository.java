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

    @Query(value = "SELECT  c.nome as nomecirurgia, m.nome as nomemed, p.nome as nomepac, c.descricao" +
            " FROM cirurgias c, paciente p, medicos m WHERE c.idcirurgia =:id AND p.idpac=c.idpac AND m.idmed = c.idmed", nativeQuery = true)
    List<CirurgiaDTO> findCirurgiaByPaciente(@Param("id") Long id);


}
