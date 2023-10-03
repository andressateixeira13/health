package com.example.health.model.cartVacina;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "cartVacina")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartVacina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVac")
    private Long id;

    @Column(name = "idPac")
    private Integer idPac;

    @Column(name = "nome", nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "dataAplic", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAplic;
}
