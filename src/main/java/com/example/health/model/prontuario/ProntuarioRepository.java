package com.example.health.model.prontuario;

import com.example.health.model.cirurgia.CirurgiaDTO;
import com.example.health.model.prontuario.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
    public Prontuario  getById(Long id);

    public Optional<Prontuario>findById(Long id);

    @Query(value = "SELECT  p.nome as nomepac, m.nome as nomemed, po.limitacoes, po.alergias, p.datanasc, p.genero" +
            " FROM prontuario po, paciente p, medicos m WHERE po.idpront =:id AND p.idpac=po.idpac AND m.idmed = po.idmed", nativeQuery = true)
    ProntuarioDTO findProntuarioByPaciente(@Param("id") Long id);
}
