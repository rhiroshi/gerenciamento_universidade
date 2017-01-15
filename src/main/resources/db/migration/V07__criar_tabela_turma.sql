CREATE TABLE turma(
	codigo VARCHAR(20) PRIMARY KEY,
	disciplina BIGINT(20),
	numero_alunos Integer,
	semestre Integer,
	Professor BIGINT(20),
	FOREIGN KEY (disciplina) REFERENCES disciplina(codigo) ON DELETE CASCADE,
	FOREIGN KEY (professor) REFERENCES professor(siape) ON DELETE CASCADE
)
