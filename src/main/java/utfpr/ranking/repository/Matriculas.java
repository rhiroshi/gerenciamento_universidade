package utfpr.ranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utfpr.ranking.model.Matricula;

@Repository
public interface Matriculas extends JpaRepository<Matricula, Long>{

}
