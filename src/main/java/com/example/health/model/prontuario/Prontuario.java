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
    @Column(name = "idpront")
    private Long idpront;

    @Column(name = "idpac", nullable = false)
    private Integer idpac;

    @Column(name = "idmed")
    private Integer idmed;

    @Column(name = "limitacoes", length = 100)
    private String limitacoes;

    @Column(name = "alergias", length = 100)
    private String alergias;

}
