package com.example.health.model.prontuario;

import com.example.health.model.prontuario.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
}
