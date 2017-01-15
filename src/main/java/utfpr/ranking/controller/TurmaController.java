package utfpr.ranking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utfpr.ranking.model.Turma;
import utfpr.ranking.repository.Disciplinas;
import utfpr.ranking.service.CadastroTurmaService;

@Controller
public class TurmaController {

	@Autowired
	private Disciplinas disciplinas;
	@Autowired
	private CadastroTurmaService turmaService;
	
	@RequestMapping(value="/cadastro-turma", method=RequestMethod.GET)
	public ModelAndView cadastroTurma(Turma turma){
		ModelAndView mv = new ModelAndView("cadastro-turma");
		mv.addObject("disciplinas",disciplinas.findAll());
		return mv;
	}
	
	@RequestMapping(value="/cadastro-turma", method=RequestMethod.POST)
	public ModelAndView cadastrarTurma(@Valid Turma turma,BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			return cadastroTurma(turma);
		}
		System.out.println(turma.getCodigo());
		turmaService.salvar(turma);
		attributes.addFlashAttribute("mensagem", "Turma cadastrada com sucesso!");
		return new ModelAndView("redirect:/cadastro-turma");
	}
	
}
