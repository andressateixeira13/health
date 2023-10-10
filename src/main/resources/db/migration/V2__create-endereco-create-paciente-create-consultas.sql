create table endereco(
                         idEnd serial not null primary key ,
                         bairro varchar(100) not null,
                         cep varchar(9) not null,
                         complemento varchar(100),
                         numero varchar(20),
                         uf char(2) not null,
                         cidade varchar(100) not null
);
create table paciente(
                         idPac serial not null primary key,
                         nome varchar(100) not null ,
                         dataNasc date not null ,
                         genero varchar(10),
                         idEnd integer,
                         email varchar(100) not null ,
                         foreign key (idEnd) REFERENCES endereco(idEnd)
);

create table consultas(
                          idCon serial not null primary key ,
                          idPac integer,
                          dataCon date not null ,
                          motivo varchar(200) not null ,
                          diagnostico varchar(300) not null ,
                          tratamento varchar(300),
                          prescricao varchar(300),
                          foreign key (idPac) REFERENCES paciente(idPac)
);