package utfpr.ranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utfpr.ranking.model.Atividade;

@Repository
public interface Atividades extends JpaRepository<Atividade, Long>{

}
