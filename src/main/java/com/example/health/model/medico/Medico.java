package com.example.health.model.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "medicos")
@NoArgsConstructor // Construtor sem argumentos
@AllArgsConstructor // Construtor com todos os argumentos
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMed")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dataNasc;

    @Column(name = "especialidade", nullable = false)
    private String especialidade;

    @Column(name = "crm", nullable = false)
    private String crm;
}
