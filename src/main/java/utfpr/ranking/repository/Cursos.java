package utfpr.ranking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utfpr.ranking.model.Curso;
import utfpr.ranking.model.Departamento;

@Repository
public interface Cursos extends JpaRepository<Curso,Long>{

	public List<Curso> findByDepartamento(Departamento dept);
}
	