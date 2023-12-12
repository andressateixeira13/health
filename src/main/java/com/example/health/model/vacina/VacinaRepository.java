package com.example.health.model.vacina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    public Vacina getById(Long id);

    @Query(value = "SELECT p.nome, v.nome as nomevac, v.lote, v.dataaplic" +
            " FROM paciente p, vacina v WHERE v.idpac=:id AND p.idpac=:id", nativeQuery = true)
    List<VacinaDTO> findVacinasPorPaciente(Long id);

}
