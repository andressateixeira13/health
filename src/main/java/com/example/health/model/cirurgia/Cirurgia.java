package com.example.health.model.cirurgia;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "cirurgias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cirurgia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCirurgia")
    private Long id;

    @Column(name = "idPac")
    private Integer idPac;

    @Column(name = "idMed")
    private Integer idMed;

    @Column(name = "nome", nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "descricao", nullable = false, length = 300)
    @NotBlank
    private String descricao;

    // Outras anotações, getters e setters
}
