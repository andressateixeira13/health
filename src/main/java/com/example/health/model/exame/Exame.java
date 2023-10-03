package com.example.health.model.exame;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exames")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExame")
    private Long id;

    @Column(name = "idPac")
    private Integer idPac;

    @Column(name = "nome", nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "descricao", length = 100)
    private String descricao;

    @Lob
    @Column(name = "file_data")
    private byte[] fileData;

    // Outras anotações, getters e setters
}
