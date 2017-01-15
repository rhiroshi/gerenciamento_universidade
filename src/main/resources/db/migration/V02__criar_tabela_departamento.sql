CREATE TABLE departamento(
	codigo BIGINT(20) primary key auto_increment,
	nomedepartamento VARCHAR(255) NOT NULL,
	coordenador_departamento BIGINT(20) DEFAULT NULL,
	FOREIGN KEY (coordenador_departamento) REFERENCES professor(siape) ON DELETE CASCADE ON UPDATE CASCADE,
	UNIQUE KEY (nomedepartamento)
);

ALTER TABLE professor ADD departamento BIGINT(20);
ALTER TABLE professor ADD FOREIGN KEY(departamento) REFERENCES departamento(codigo) ON DELETE CASCADE ON UPDATE CASCADE;