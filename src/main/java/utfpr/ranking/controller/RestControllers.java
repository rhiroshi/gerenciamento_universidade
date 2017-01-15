package utfpr.ranking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utfpr.ranking.model.Aluno;
import utfpr.ranking.model.Atividade;
import utfpr.ranking.model.Curso;
import utfpr.ranking.model.Departamento;
import utfpr.ranking.model.Disciplina;
import utfpr.ranking.model.Professor;
import utfpr.ranking.model.Turma;
import utfpr.ranking.repository.Alunos;
import utfpr.ranking.repository.Atividades;
import utfpr.ranking.repository.Cursos;
import utfpr.ranking.repository.Departamentos;
import utfpr.ranking.repository.Professores;
import utfpr.ranking.repository.Turmas;
import utfpr.ranking.service.CadastroAtividadeService;

@RestController
public class RestControllers {

	@Autowired
	private Professores professores;
	@Autowired
	private Turmas turmas;
	@Autowired
	private Cursos cursos;
	@Autowired
	private Departamentos departamentos;
	@Autowired
	private Alunos alunos;
	@Autowired
	private Atividades atividades;
	@Autowired
	private CadastroAtividadeService atividadesService;
	
	@RequestMapping(value="/cadastro-professor/query", method=RequestMethod.GET)
	public List<Professor> buscaProfessor(@RequestParam String nome){
		List<Professor> lista;
		lista = professores.findByNomeContaining(nome);
		return lista;
	}
	
	@RequestMapping(value="cadastro-turma/query", method=RequestMethod.GET)
	public List<Turma> buscaTurma(@RequestParam Long disciplina){
		Disciplina disc = new Disciplina();
		disc.setCodigo(disciplina);
		List<Turma> lista;
		lista = turmas.findByDisciplina(disc);
		return lista;
	}
	
	@RequestMapping(value="/turma/listar", method=RequestMethod.GET)
	public List<Turma> listarTurmas(@RequestParam String busca){
		List<Turma> lista;
		lista = turmas.porNomeDisciplina(busca);
		return lista;
	}
	
	@RequestMapping(value="/cursos/getCursos", method=RequestMethod.GET)
	public List<Curso> buscaCursos(@RequestParam Long departamento){
		Departamento dept = departamentos.findOne(departamento);
		List<Curso> lista = cursos.findByDepartamento(dept);
		return lista;
	}
	
	@RequestMapping(value = "/alunos/procura", method=RequestMethod.GET)
	public Aluno procuraAluno(@RequestParam Long ra){
		return alunos.findByRa(ra);
	}
	
	@RequestMapping(value = "/alunos/procuraPorNome", method=RequestMethod.GET)
	public List<Aluno> procuraAlunoPorNome(@RequestParam String nome){
		return alunos.findByNomeAlunoIgnoreCaseContaining(nome);
	}

	@RequestMapping(value="/atividades/findAll", method=RequestMethod.GET)
	public List<Atividade> listarAtividades(){
		return atividades.findAll();
	}
	
	@RequestMapping(value="/atividades/novo66", method=RequestMethod.POST)
	public Integer novaAtividade66(@RequestParam String descricao, @RequestParam Integer peso){
		Atividade at = new Atividade();
		at.setDescricao(descricao);
		at.setPeso(peso);
		at.setCodigo(66);
		atividadesService.salvar(at); //assistir AW 11.2
		return 10203040;
	}
	
}
