package com.example.health.model.medico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmed;

    @NotBlank
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dataNasc;

    @NotBlank
    private String especialidade;

    @NotBlank
    private String crm;
}
