package utfpr.ranking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utfpr.ranking.model.Aluno;

@Repository
public interface Alunos extends JpaRepository<Aluno,Long> {
	public Aluno findByRa(Long ra);
	public List<Aluno> findByNomeAlunoIgnoreCaseContaining(String nome);
}
