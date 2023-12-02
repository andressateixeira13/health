create table medicos(
                        idMed serial not null primary key ,
                        nome varchar(100) not null ,
                        dataNasc date not null ,
                        especialidade varchar(100) not null ,
                        crm varchar(100) not null
);
