package utfpr.ranking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utfpr.ranking.model.Curso;
import utfpr.ranking.model.Departamento;
import utfpr.ranking.repository.Cursos;

@RestController
@RequestMapping("/GetCursos")
public class GetCursosController {

	@Autowired
	private Cursos cursos;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Curso> get(@RequestParam Long id){
		Departamento dept = new Departamento();
		dept.setCodigo(id);
		return cursos.findByDepartamento(dept);
	}
}
