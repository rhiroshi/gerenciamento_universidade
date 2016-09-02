package utfpr.ranking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utfpr.ranking.model.Aluno;
import utfpr.ranking.model.Curso;
import utfpr.ranking.model.Departamento;
import utfpr.ranking.model.Disciplina;
import utfpr.ranking.model.Funcionario;
import utfpr.ranking.model.TipoFuncionario;
import utfpr.ranking.repository.Cursos;
import utfpr.ranking.repository.Departamentos;
import utfpr.ranking.service.CadastroAlunoService;
import utfpr.ranking.service.CadastroCursoService;
import utfpr.ranking.service.CadastroDepartamentoService;
import utfpr.ranking.service.CadastroDisciplinaService;

@Controller
public class AppController {

	
	
	@Autowired
	private Departamentos departamentos;
	
	@Autowired
	private CadastroDepartamentoService departamentoService;
	
	@Autowired
	private Cursos cursos;
	
	@Autowired
	private CadastroAlunoService alunoService;
	
	@Autowired
	private CadastroCursoService cursoService;
	
	@Autowired 
	private CadastroDisciplinaService disciplinaService;
	
	@RequestMapping("/cadastro-professor")
	public ModelAndView CadastroProfessor(Funcionario funcionario){
		ModelAndView mv = new ModelAndView("cadastro-professor");
		mv.addObject("tiposFuncionario",TipoFuncionario.values());
		mv.addObject("departamentos",departamentos.findAll());  //ADICIONAR DEPARTAMENTOS
		return mv;
	}
	
	@RequestMapping(value = "/cadastro-professor", method = RequestMethod.POST)
	public ModelAndView salvarFuncionario(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes){
		System.out.print("Tipo:"+funcionario.getTipoFuncionario()+"\nCodigo: " + funcionario.getCodigo() + "\n" + "Nome : " + funcionario.getNome() + "\n" + "Endereço : " + funcionario.getEndereco());
		return new ModelAndView("cadastro-professor");
	}
	
	@RequestMapping("/cadastro-departamento")
	public ModelAndView CadastroDepartamento(Departamento departamento){
		ModelAndView mv = new ModelAndView("cadastro-departamento");
		return mv;
	}
	
	@RequestMapping(value="/cadastro-departamento", method=RequestMethod.POST)
	public ModelAndView salvarDepartamento(@Valid Departamento departamento, BindingResult result, RedirectAttributes attributes){
		departamentoService.salvar(departamento);
		return new ModelAndView("cadastro-departamento");
	}
	
	@RequestMapping("/cadastro-curso")
	public ModelAndView CadastroCurso(Curso curso){
		ModelAndView mv = new ModelAndView("cadastro-curso");
		mv.addObject("departamentos",departamentos.findAll());
		return mv;
	}
	
	@RequestMapping(value="/cadastro-curso", method=RequestMethod.POST)
	public ModelAndView salvarCurso(@Valid Curso curso, BindingResult result, RedirectAttributes attributes){
		cursoService.salvar(curso);
		return new ModelAndView("cadastro-curso");
	}
	
	@RequestMapping("/cadastro-aluno")
	public ModelAndView cadastraAluno(Aluno aluno){
		ModelAndView mv = new ModelAndView("cadastro-aluno");
		mv.addObject("departamentos",departamentos.findAll());
		mv.addObject("cursos",cursos.findAll());
		return mv;
	}
	@RequestMapping(value="/cadastro-aluno",method=RequestMethod.POST)
	public ModelAndView salvarAluno(@Valid Aluno aluno, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			return cadastraAluno(aluno);
		}
		
		alunoService.salvar(aluno);
		return new ModelAndView("cadastro-aluno");
	}
	@RequestMapping("/cadastro-disciplina")
	public ModelAndView cadastraDisciplina(Disciplina disciplina){
		ModelAndView mv = new ModelAndView("cadastro-disciplina");
		mv.addObject("cursos",cursos.findAll());
		return mv;
	}
	@RequestMapping(value="/cadastro-disciplina",method=RequestMethod.POST)
	public ModelAndView salvarDisciplina(@Valid Disciplina disciplina, BindingResult result, RedirectAttributes attributes){
		//System.out.printf(Integer.toString(disciplina.getCursos().size()));
		
		if(result.hasErrors()){
			return cadastraDisciplina(disciplina);
		}
		disciplinaService.salvar(disciplina);
		return new ModelAndView("cadastro-disciplina");
	}
}
