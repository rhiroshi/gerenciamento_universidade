package utfpr.ranking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utfpr.ranking.model.Matricula;
import utfpr.ranking.repository.Matriculas;

@Service
public class CadastroMatriculaService {

	@Autowired
	private Matriculas matriculas;
	
	public void salvar(Matricula mat){
		this.matriculas.save(mat);
	}
	
}
