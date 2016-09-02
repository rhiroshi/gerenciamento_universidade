package utfpr.ranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import utfpr.ranking.model.Aluno;

public interface Alunos extends JpaRepository<Aluno,Integer> {

}
