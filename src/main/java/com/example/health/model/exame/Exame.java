package com.example.health.model.exame;

import com.example.health.model.paciente.Paciente;
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
    @Column(name = "idexame")
    private Long idexame;

    @ManyToOne
    @JoinColumn(name = "idpac")
    private Paciente idpac;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    private byte[] fileData;

}
