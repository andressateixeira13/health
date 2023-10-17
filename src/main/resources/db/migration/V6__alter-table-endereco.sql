ALTER TABLE endereco ADD COLUMN rua varchar(100);
ALTER TABLE endereco ADD COLUMN idpac int;
ALTER TABLE endereco ADD CONSTRAINT endereco_paciente_fkey FOREIGN KEY (idpac) REFERENCES paciente(idpac);
ALTER TABLE paciente DROP COLUMN idend;