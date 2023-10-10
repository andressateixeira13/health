create table cartVacina(
                           idVac serial not null primary key ,
                           idPac integer,
                           nome varchar(100) not null ,
                           dataAplic date not null,
                           foreign key (idPac) REFERENCES paciente(idPac)
);

create table exames(
                       idExame serial not null primary key ,
                       idPac integer,
                       nome varchar(100) not null ,
                       descricao varchar(100) ,
                       file_data BYTEA,
                       foreign key (idPac) REFERENCES paciente(idPac)
);
