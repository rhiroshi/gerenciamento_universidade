package utfpr.ranking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utfpr.ranking.model.Designacao;
import utfpr.ranking.repository.Atividades;
import utfpr.ranking.service.CadastroDesignacaoService;

@Controller
public class DesignacaoController {

	@Autowired
	private CadastroDesignacaoService designacaoService;
	@Autowired
	private Atividades atividades;
	
	
	@RequestMapping(value="/professor/designarAtividade", method=RequestMethod.GET)
	public ModelAndView designarAtividade(Designacao designacao){
		ModelAndView mv = new ModelAndView("designar-para-professor");
		return mv;
	}
	
	@RequestMapping(value="/professor/designarAtividade", method=RequestMethod.POST)
	public ModelAndView cadastroDesignacao(@Valid Designacao designacao, RedirectAttributes attributes, BindingResult result){
		designacao.setAtividade(atividades.findOne(designacao.getAtividade().getId()));
		if(result.hasErrors()){
			return designarAtividade(designacao);
		}
		designacaoService.salvar(designacao);
		ModelAndView mv = new ModelAndView("redirect:/professor/designarAtividade");
		attributes.addFlashAttribute("mensagem", "Designacao salva com sucesso");
		return mv;
	}
	
}
