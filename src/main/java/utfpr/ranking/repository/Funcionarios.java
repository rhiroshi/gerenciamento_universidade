package utfpr.ranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.ranking.model.Funcionario;

public interface Funcionarios extends JpaRepository<Funcionario, Integer> {

}
