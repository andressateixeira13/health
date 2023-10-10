package com.example.health.model.cartVacina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartVacinaRepository extends JpaRepository<CartVacina, Long> {
    public CartVacina getById(Long id);

}
