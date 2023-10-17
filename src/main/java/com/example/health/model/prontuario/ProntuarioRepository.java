package com.example.health.model.prontuario;

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

    @Query(value = "SELECT a.id as idpac, a.nome as nome, a.dataNasc as dataNasc, a.genero as genero, a.email as email"
            + "FROM paciente a where a.id.consulta =:id", nativeQuery = true)
    List<Prontuario> findProntuarioByPaciente(@Param("id") int id);

}
