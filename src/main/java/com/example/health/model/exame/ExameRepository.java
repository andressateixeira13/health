package com.example.health.model.exame;

import com.example.health.model.exame.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
}