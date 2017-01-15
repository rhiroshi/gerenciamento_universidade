CREATE TABLE atividade(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo INTEGER,
	descricao VARCHAR(512),
	peso INTEGER
);

INSERT INTO atividade VALUES(DEFAULT, 1, 'Colaborador de pós', 10);
INSERT INTO atividade VALUES(DEFAULT, 2, 'Coordenador de programa', 10);
INSERT INTO atividade VALUES(DEFAULT, 3, 'Participante de programa', 20);
INSERT INTO atividade VALUES(DEFAULT, 4, 'Coordenador de projeto', 20);
INSERT INTO atividade VALUES(DEFAULT, 5, 'Coordenador de projeto institucional', 30);
INSERT INTO atividade VALUES(DEFAULT, 6, 'Coordenador de projeto internacional', 5);
INSERT INTO atividade VALUES(DEFAULT, 7, 'Coordenador de projeto de pesquisa', 40);
INSERT INTO atividade VALUES(DEFAULT, 66, 'Atividade de interesse', 0);