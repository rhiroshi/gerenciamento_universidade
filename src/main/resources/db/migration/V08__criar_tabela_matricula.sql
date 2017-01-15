CREATE TABLE matricula(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	aluno BIGINT(20),
	turma VARCHAR(20),
	nota float DEFAULT 0,
	semestre int,
	FOREIGN KEY (aluno) REFERENCES aluno(ra) ON DELETE CASCADE,
	FOREIGN KEY (turma) REFERENCES turma(codigo) ON DELETE CASCADE
);