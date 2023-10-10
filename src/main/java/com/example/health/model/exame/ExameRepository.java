package com.example.health.model.exame;

import com.example.health.model.exame.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ExameRepository extends JpaRepository<Exame, Long> {
    public Exame getById(Long id);

    public Optional<Exame> findById(Long id);

}