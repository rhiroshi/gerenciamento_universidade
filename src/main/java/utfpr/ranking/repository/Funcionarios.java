package utfpr.ranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utfpr.ranking.model.Funcionario;

@Repository
public interface Funcionarios extends JpaRepository<Funcionario, Long> {

}
