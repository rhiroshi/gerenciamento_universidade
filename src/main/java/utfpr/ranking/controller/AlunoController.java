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
import utfpr.ranking.repository.Departamentos;
import utfpr.ranking.service.CadastroAlunoService;

@Controller
public class AlunoController {

	@Autowired
	private CadastroAlunoService alunoService;
	@Autowired
	private Departamentos departamentos;
	
	@RequestMapping("/cadastro-aluno")
	public ModelAndView cadastraAluno(Aluno aluno){
		ModelAndView mv = new ModelAndView("cadastro-aluno");
		mv.addObject("departamentos",departamentos.findAll());
		return mv;
	}
	@RequestMapping(value="/cadastro-aluno",method=RequestMethod.POST)
	public ModelAndView salvarAluno(@Valid Aluno aluno, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			return cadastraAluno(aluno);
		}
		
		alunoService.salvar(aluno);
		attributes.addAttribute("mensagem", "Aluno cadastrado com sucesso");
		return new ModelAndView("redirect:/cadastro-aluno");
	}
	
	
}
