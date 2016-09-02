CREATE TABLE aluno(
	codigo BIGINT(20) PRIMARY KEY,
	nomealuno VARCHAR(255) NOT NULL,
	datanascimento DATE NOT NULL,
	endereco VARCHAR(255) NOT NULL,
	departamento BIGINT(20),
	curso BIGINT(20),
	FOREIGN KEY (departamento) REFERENCES departamento(codigo),
	FOREIGN KEY (curso) REFERENCES curso(codigo),
	UNIQUE KEY(nomealuno)
)
