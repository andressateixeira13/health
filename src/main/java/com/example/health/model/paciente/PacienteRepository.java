package com.example.health.model.paciente;

import com.example.health.model.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    public Paciente getById(Long id);

    public Optional<Paciente>findById(Long id);

    @Query(value = "SELECT p.nome, e.rua, e.numero, e.bairro, e.complemento, e.cidade, e.uf, e.cep" +
            " FROM paciente p, endereco e WHERE p.idpac=:id AND e.idpac=:id", nativeQuery = true)
    List<PacienteDTO> findEnderecoPorPaciente(Long id);


}
