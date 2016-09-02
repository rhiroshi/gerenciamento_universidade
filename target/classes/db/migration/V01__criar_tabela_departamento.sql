CREATE TABLE departamento(
	codigo BIGINT(20) primary key auto_increment,
	nomedepartamento VARCHAR(255) NOT NULL,
	UNIQUE KEY (nomedepartamento)
);