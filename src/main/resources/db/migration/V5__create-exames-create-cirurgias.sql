create table exames(
    idExame serial not null primary key ,
    idPac integer,
    nome varchar(100) not null ,
    descricao varchar(100) ,
    file_data BYTEA,
    foreign key (idPac) REFERENCES paciente(idPac)
);
create table cirurgias(
    idCirurgia serial not null primary key ,
    idPac integer ,
    idMed integer,
    nome varchar(100) not null ,
    descricao varchar(300) not null ,
    foreign key (idPac) REFERENCES paciente(idPac),
    foreign key (idMed) REFERENCES medicos(idMed)
);

ALTER TABLE cartVacina ADD CONSTRAINT cartVacina_paciente_fkey FOREIGN KEY (idPac) REFERENCES paciente(idPac);