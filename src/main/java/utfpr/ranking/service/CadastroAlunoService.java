package utfpr.ranking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utfpr.ranking.model.Aluno;
import utfpr.ranking.repository.Alunos;

@Service
public class CadastroAlunoService {

	@Autowired
	Alunos alunos;
	
	public void salvar(Aluno aluno){
		this.alunos.save(aluno);
	}
}
