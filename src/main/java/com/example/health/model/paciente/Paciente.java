package com.example.health.model.paciente;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Embedded
    @JoinColumn(name = "idGenero")
    private Genero gerero;
    @Embedded
    @JoinColumn(name = "idEnd")
    private Endereco endereco;
    @Email(message = "Email inválido")
    private String email;


}
