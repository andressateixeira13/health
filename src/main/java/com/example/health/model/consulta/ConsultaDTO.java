package com.example.health.model.consulta;

import java.util.Date;

public interface ConsultaDTO {
    Long getIdcon();
    String getIdpac();
    Date getDatacon();

    String getTratamento();
    String getDiagnostico();
    String getPrescricao();
}
