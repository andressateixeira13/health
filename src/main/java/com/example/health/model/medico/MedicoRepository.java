package com.example.health.model.medico;

import com.example.health.model.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    public Medico getById(Long id);

    public Optional<Medico> findById(Long id);

    /*melhorar @Query*/
    @Query("SELECT m FROM Medico m WHERE m.especialidade = :especialidade")
    List<Medico> findByEspecialidade(String especialidade);
}
