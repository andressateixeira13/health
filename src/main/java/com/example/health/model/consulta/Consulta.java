package com.example.health.model.consulta;

import com.example.health.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcon;

    @JoinColumn(name = "idpac")
    private Long idpac;
    @Temporal(TemporalType.DATE)
    private Date datacon;

    @Size(max = 200)
    private String motivo;

    @Size(max = 300)
    private String diagnostico;

    @Size(max = 300)
    private String tratamento;

    @Size(max = 300)
    private String prescricao;


}
