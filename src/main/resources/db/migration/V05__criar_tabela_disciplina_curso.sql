CREATE TABLE disciplina_curso(
	disciplina BIGINT(20),
	curso BIGINT(20),
	PRIMARY KEY(disciplina, curso),
	FOREIGN KEY (disciplina) REFERENCES disciplina(codigo),
	FOREIGN KEY(curso) REFERENCES curso(codigo)
)