package utfpr.ranking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utfpr.ranking.model.Professor;

@Repository
public interface Professores extends JpaRepository<Professor, Long>{

	public List<Professor> findByNomeContaining(String Nome);
	
}
