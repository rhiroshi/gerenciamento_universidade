package utfpr.ranking.repository.helper;

import java.util.List;

import utfpr.ranking.model.Turma;

public interface TurmasQueries {

	public List<Turma> porNomeDisciplina(String nomeDisciplina);
	
}
