package com.example.health.model.prontuario;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "prontuario")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPront")
    private Long id;

    @Column(name = "idPac", nullable = false)
    private Integer idPac;

    @Column(name = "idMed")
    private Integer idMed;

    @Column(name = "limitacoes", length = 100)
    private String limitacoes;

    @Column(name = "alergias", length = 100)
    private String alergias;

    // Outras anotações, getters e setters
}
