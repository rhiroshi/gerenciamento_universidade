package utfpr.ranking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utfpr.ranking.model.Curso;
import utfpr.ranking.repository.Cursos;

@Service
public class CadastroCursoService {

	@Autowired
	Cursos cursos;
	
	public void salvar(Curso curso){
		this.cursos.save(curso);
	}
	
}
