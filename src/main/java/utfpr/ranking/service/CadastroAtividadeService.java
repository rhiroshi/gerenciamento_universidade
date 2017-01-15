package utfpr.ranking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utfpr.ranking.model.Atividade;
import utfpr.ranking.repository.Atividades;

@Service
public class CadastroAtividadeService {

	@Autowired
	private Atividades atividades;
	
	public Atividade salvar(Atividade atividade){
		return this.atividades.saveAndFlush(atividade);
	}
	
}
