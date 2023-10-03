package com.example.health.model.cirurgia;

import com.example.health.model.cirurgia.Cirurgia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CirurgiaRepository extends JpaRepository<Cirurgia, Long> {
}