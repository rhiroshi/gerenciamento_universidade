package utfpr.ranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utfpr.ranking.model.Departamento;

@Repository
public interface Departamentos extends JpaRepository<Departamento, Long> {

}
