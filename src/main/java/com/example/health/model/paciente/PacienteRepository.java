package com.example.health.model.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    public Paciente getById(Long id);

    public Optional<Paciente>findById(Long id);

   /* @Query(value = "SELECT a.id as id, a.nome as nome, a.dataNasc as dataNasc, a.genero as genero, a.email as email"
    + "FROM paciente a where a.id.consulta =:id", nativeQuery = true)
    List<PacienteDTO> findPacienteByConsulta(@Param("id") int id);
    ---> fazer na consulta
    */
}
