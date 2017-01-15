package utfpr.ranking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utfpr.ranking.model.Disciplina;
import utfpr.ranking.model.Turma;
import utfpr.ranking.repository.helper.TurmasQueries;

@Repository
public interface Turmas extends JpaRepository<Turma, Long>, TurmasQueries{

	public List<Turma> findByDisciplina(Disciplina disciplina);
}
