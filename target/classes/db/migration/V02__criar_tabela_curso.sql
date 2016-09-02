CREATE TABLE curso(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nomeCurso VARCHAR(255),
	departamento BIGINT(20),
	FOREIGN KEY (departamento) REFERENCES departamento(codigo), 
	UNIQUE KEY(nomeCurso)
);
