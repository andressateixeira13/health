create table prontuario(
                           idPront serial not null primary key ,
                           idPac integer not null ,
                           idMed integer,
                           limitacoes varchar(100),
                           alergias varchar(100),
                           foreign key (idPac) REFERENCES paciente(idPac),
                           foreign key (idMed) REFERENCES medicos(idMed)
);

ALTER TABLE paciente ADD COLUMN telefone varchar(11);
