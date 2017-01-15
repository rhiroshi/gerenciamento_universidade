package utfpr.ranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utfpr.ranking.model.Disciplina;

@Repository
public interface Disciplinas extends JpaRepository<Disciplina,Long>{

}
