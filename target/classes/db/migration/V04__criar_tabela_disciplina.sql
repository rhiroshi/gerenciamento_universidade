CREATE TABLE disciplina(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nomedisciplina VARCHAR(255),
	horas_aula Integer,
	UNIQUE KEY(nomedisciplina)
)