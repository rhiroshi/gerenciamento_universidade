package utfpr.ranking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utfpr.ranking.model.Designacao;
import utfpr.ranking.repository.Designacoes;

@Service
public class CadastroDesignacaoService {

	@Autowired
	Designacoes designacoes;
	
	public void salvar(Designacao designacao){
		this.designacoes.save(designacao);
	}
	
}
