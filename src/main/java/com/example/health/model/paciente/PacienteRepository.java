package com.example.health.model.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    public Paciente getById(Long id);

    public Optional<Paciente>findById(Long id);

  /* @Query(value = "SELECT a.idend as idend, e.rua as rua, e.bairro as bairro, e.cidade as cidade, e.uf as uf"
    + "FROM paciente a, endereco e where a.idpac =:id", nativeQuery = true)
    List<Paciente> findPacienteByEndereco(@Param("id") Long id);*/


}
