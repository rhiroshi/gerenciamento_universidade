package utfpr.ranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utfpr.ranking.model.Designacao;

@Repository
public interface Designacoes extends JpaRepository<Designacao, Long>{

}
