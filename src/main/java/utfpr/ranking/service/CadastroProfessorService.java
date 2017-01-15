package utfpr.ranking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utfpr.ranking.model.Professor;
import utfpr.ranking.repository.Professores;

@Service
public class CadastroProfessorService {

	@Autowired
	private Professores prof;
	
	public void salvar(Professor prof){
		this.prof.save(prof);
	}
	
}
