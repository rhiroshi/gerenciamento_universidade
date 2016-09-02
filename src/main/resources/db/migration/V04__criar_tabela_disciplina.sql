CREATE TABLE disciplina(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nomedisciplina VARCHAR(255),
	UNIQUE KEY(nomedisciplina)
)