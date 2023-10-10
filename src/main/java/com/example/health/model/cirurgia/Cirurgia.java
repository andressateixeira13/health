package com.example.health.model.cirurgia;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "cirurgias")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cirurgia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcirurgia")
    private Long idcirurgia;

    @Column(name = "idpac")
    private Integer idpac;

    @Column(name = "idmed")
    private Integer idmed;

    @Column(name = "nome", nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "descricao", nullable = false, length = 300)
    @NotBlank
    private String descricao;


}
