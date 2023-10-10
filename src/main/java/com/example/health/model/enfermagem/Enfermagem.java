package com.example.health.model.enfermagem;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "enfermagem")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enfermagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idenf")
    private Long idenf;

    @Column(name = "nome", nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "datanasc", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datanasc;

    @Column(name = "cargo", nullable = false)
    @NotBlank
    private String cargo;

    @Column(name = "coren", nullable = false)
    @NotBlank
    private String coren;
}
