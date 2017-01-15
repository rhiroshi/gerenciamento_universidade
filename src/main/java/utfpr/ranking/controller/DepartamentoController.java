package utfpr.ranking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utfpr.ranking.model.Departamento;
import utfpr.ranking.service.CadastroDepartamentoService;

@Controller
public class DepartamentoController {

	@Autowired
	private  CadastroDepartamentoService departamentoService;
	

	@RequestMapping("/cadastro-departamento")
	public ModelAndView cadastroDepartamento(Departamento departamento){
		ModelAndView mv = new ModelAndView("cadastro-departamento");
		return mv;
	}
	
	@RequestMapping(value="/cadastro-departamento", method=RequestMethod.POST)
	public ModelAndView salvarDepartamento(@Valid Departamento departamento, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			return cadastroDepartamento(departamento);
		}
		departamentoService.salvar(departamento);
		attributes.addFlashAttribute("mensagem", "Departamento cadastrado com sucesso");
		return new ModelAndView("redirect:/cadastro-departamento");
	}
	
	
}
