CREATE TABLE designacao(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	professor BIGINT(20),
	atividade BIGINT(20),
	inicio DATE,
	fim DATE,
	FOREIGN KEY(professor) REFERENCES professor(siape),
	FOREIGN KEY(atividade) REFERENCES atividade(id)
);