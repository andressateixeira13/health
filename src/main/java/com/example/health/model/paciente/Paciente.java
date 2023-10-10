package com.example.health.model.paciente;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpac;
    @NotBlank
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date datanasc;
    @NotBlank
    private String genero;
    /*@Embedded
    @JoinColumn(name = "idEnd")
    private Endereco endereco;*/

    private Long idend;
    @Email(message = "Email inválido")
    private String email;


}
