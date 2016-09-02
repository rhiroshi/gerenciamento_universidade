package utfpr.ranking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utfpr.ranking.model.Departamento;
import utfpr.ranking.repository.Departamentos;

@Service
public class CadastroDepartamentoService {

	@Autowired 
	Departamentos departamentos;
	
	public void salvar(Departamento departamento){
		this.departamentos.save(departamento);
	}
	
}
