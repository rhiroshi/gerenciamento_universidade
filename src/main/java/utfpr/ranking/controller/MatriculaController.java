package utfpr.ranking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utfpr.ranking.model.Matricula;
import utfpr.ranking.repository.Departamentos;
import utfpr.ranking.service.CadastroMatriculaService;

@Controller
public class MatriculaController {

	@Autowired
	private CadastroMatriculaService matriculaService;
	@Autowired
	private Departamentos departamentos;

	@RequestMapping("/cadastro-matricula")
	public ModelAndView cadastraMatricula(Matricula matricula){
		ModelAndView mv = new ModelAndView("cadastro-matricula");
		mv.addObject("departamentos",departamentos.findAll());
		return mv;
	}
	@RequestMapping(value="/cadastro-matricula",method=RequestMethod.POST)
	public ModelAndView salvarMatricula(@Valid Matricula matricula, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			return cadastraMatricula(matricula);
		}
		matriculaService.salvar(matricula);
		attributes.addFlashAttribute("mensagem", "Matricula salva com sucesso, codigo: "+matricula.getCodigo());
		return new ModelAndView("redirect:/cadastro-matricula");
	}
	
}
