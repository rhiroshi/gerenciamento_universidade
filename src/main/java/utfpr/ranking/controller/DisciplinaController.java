package utfpr.ranking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utfpr.ranking.model.Disciplina;
import utfpr.ranking.repository.Cursos;
import utfpr.ranking.service.CadastroDisciplinaService;

@Controller
public class DisciplinaController {

	@Autowired
	private CadastroDisciplinaService disciplinaService;
	@Autowired
	private Cursos cursos;
	
	@RequestMapping("/cadastro-disciplina")
	public ModelAndView cadastraDisciplina(Disciplina disciplina){
		ModelAndView mv = new ModelAndView("cadastro-disciplina");
		mv.addObject("cursos",cursos.findAll());
		return mv;
	}
	@RequestMapping(value="/cadastro-disciplina",method=RequestMethod.POST)
	public ModelAndView salvarDisciplina(@Valid Disciplina disciplina, BindingResult result, RedirectAttributes attributes){
		
		if(result.hasErrors()){
			System.out.printf("Deu erro");
			return cadastraDisciplina(disciplina);
		}
		disciplinaService.salvar(disciplina);
		attributes.addFlashAttribute("mensagem", "Disciplina Cadastrada com sucesso!");
		return new ModelAndView("redirect:/cadastro-disciplina");
	}
	
	
}
