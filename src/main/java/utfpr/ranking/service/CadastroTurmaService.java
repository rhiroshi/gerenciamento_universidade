package utfpr.ranking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utfpr.ranking.model.Turma;
import utfpr.ranking.repository.Turmas;

@Service
public class CadastroTurmaService {

	@Autowired
	private Turmas turmas;
	
	public void salvar(Turma turma){
		turmas.save(turma);
	}
	
}
