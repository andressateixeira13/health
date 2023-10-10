package com.example.health.model.exame;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "exames")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExame")
    private Long id;

    @JoinColumn(name = "idPac")
    private Integer idPac;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private byte[] fileData;

}
