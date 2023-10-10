package com.example.health.model.enfermagem;

import com.example.health.model.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface EnfermagemRepository extends JpaRepository<Enfermagem, Long> {
    public Enfermagem getById(Long id);

    public Optional<Enfermagem>findById(Long id);

    // verificar query

}
