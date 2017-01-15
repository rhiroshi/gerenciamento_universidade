CREATE TABLE disciplina_curso(
	disciplina BIGINT(20),
	curso BIGINT(20),
	PRIMARY KEY(disciplina, curso),
	FOREIGN KEY (disciplina) REFERENCES disciplina(codigo) ON DELETE CASCADE,
	FOREIGN KEY(curso) REFERENCES curso(codigo) ON DELETE CASCADE
) 