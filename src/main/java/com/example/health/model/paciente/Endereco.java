package com.example.health.model.paciente;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String complemento;
    @NotBlank
    private String bairro;
    @Size(min = 8, max =9, message = "CEP inválido")
    private String cep;
    @NotBlank
    private String numero;
    @NotBlank
    private String cidade;
    @NotBlank
    @Size(max = 2)
    private String uf;
}



//@Pattern(regexp = "\\d{5}-\\d{3}", message = "Padrão de cep deve ser 99999-999")
//api https://www.gov.br/conecta/catalogo/apis/cep-codigo-de-enderecamento-postal/swagger-json/swagger_view