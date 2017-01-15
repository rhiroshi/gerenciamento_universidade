CREATE TABLE aluno(
	ra BIGINT(20) PRIMARY KEY,
	nomealuno VARCHAR(255) NOT NULL,
	datanascimento DATE NOT NULL,
	endereco VARCHAR(255) NOT NULL,
	curso BIGINT(20),
	departamento BIGINT(20),
	FOREIGN KEY (curso) REFERENCES curso(codigo) ON DELETE CASCADE,
	FOREIGN KEY (departamento) REFERENCES departamento(codigo) ON DELETE CASCADE,
	UNIQUE KEY(nomealuno)
	
)
