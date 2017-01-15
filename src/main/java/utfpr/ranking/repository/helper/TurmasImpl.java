package utfpr.ranking.repository.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import utfpr.ranking.model.Turma;

public class TurmasImpl implements TurmasQueries{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Turma> porNomeDisciplina(String nomeDisciplina) {
//		List<Turma> lista = manager                               //ESSA QUERY RESULTA EM 6 SELECTS!!!
//				.createQuery("select t from Turma as t where t.disciplina.nomeDisciplina like :nome_disciplina", Turma.class)
//				.setParameter("nome_disciplina", "%"+ nomeDisciplina + "%").getResultList();
		
		List<Turma> lista = manager   //so um select :)
				.createQuery("select t"
						+ " from Turma t join fetch t.professor p"
						+ " join fetch t.disciplina d"
						+ " join fetch p.departamento"
						+ " join fetch d.cursos"
						+ " where t.disciplina.nomeDisciplina like :nome_disciplina", Turma.class)
				.setParameter("nome_disciplina", "%" + nomeDisciplina + "%").getResultList();
				
		return lista;
	}

}
