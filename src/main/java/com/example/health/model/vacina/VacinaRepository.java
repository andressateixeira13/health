package com.example.health.model.vacina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    public Vacina getById(Long id);

}
