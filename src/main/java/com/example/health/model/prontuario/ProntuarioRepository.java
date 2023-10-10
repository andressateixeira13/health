package com.example.health.model.prontuario;

import com.example.health.model.prontuario.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
    public Prontuario  getById(Long id);

    public Optional<Prontuario>findById(Long id);

    //query

}
