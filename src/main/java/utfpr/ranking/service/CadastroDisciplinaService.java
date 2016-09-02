package utfpr.ranking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utfpr.ranking.model.Disciplina;
import utfpr.ranking.repository.Disciplinas;

@Service
public class CadastroDisciplinaService {

	@Autowired
	Disciplinas disciplinas;
	
	public void salvar(Disciplina disciplina){
		this.disciplinas.save(disciplina);
	}
	
}
