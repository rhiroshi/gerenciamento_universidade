package utfpr.ranking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utfpr.ranking.model.Curso;
import utfpr.ranking.repository.Departamentos;
import utfpr.ranking.service.CadastroCursoService;

@Controller
public class CursoController {

	@Autowired
	private CadastroCursoService cursoService;
	@Autowired
	private Departamentos departamentos;

	@RequestMapping("/cadastro-curso")
	public ModelAndView cadastroCurso(Curso curso){
		ModelAndView mv = new ModelAndView("cadastro-curso");
		mv.addObject("departamentos",departamentos.findAll());
		return mv;
	}
	
	@RequestMapping(value="/cadastro-curso", method=RequestMethod.POST)
	public ModelAndView salvarCurso(@Valid Curso curso, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			return cadastroCurso(curso);
		}
		cursoService.salvar(curso);
		attributes.addFlashAttribute("mensagem", "Curso cadastrado com sucesso");
		return new ModelAndView("redirect:/cadastro-curso");
	}
	
}
