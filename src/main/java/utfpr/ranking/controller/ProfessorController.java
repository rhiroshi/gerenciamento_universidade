package utfpr.ranking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utfpr.ranking.model.Professor;
import utfpr.ranking.repository.Departamentos;
import utfpr.ranking.service.CadastroProfessorService;

@Controller
public class ProfessorController {

	@Autowired
	private CadastroProfessorService professorService;
	@Autowired
	private Departamentos departamentos;

	@RequestMapping("/cadastro-professor")
	public ModelAndView cadastroProfessor(Professor professor){
		ModelAndView mv = new ModelAndView("cadastro-professor");
		mv.addObject("departamentos",departamentos.findAll());  //ADICIONAR DEPARTAMENTOS
		return mv;
	}
	
	@RequestMapping(value = "/cadastro-professor", method = RequestMethod.POST)
	public ModelAndView salvarFuncionario(@Valid Professor professor, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			return cadastroProfessor(professor);
		}
		professorService.salvar(professor);
		attributes.addFlashAttribute("mensagem", "Professor cadastrado com sucesso");
		return new ModelAndView("redirect:/cadastro-professor");
	}
	
	
}
