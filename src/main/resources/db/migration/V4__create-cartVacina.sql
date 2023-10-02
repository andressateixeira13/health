create table cartVacina(
    idVac serial not null primary key ,
    idPac integer,
    nome varchar(100) not null ,
    dataAplic date not null
);