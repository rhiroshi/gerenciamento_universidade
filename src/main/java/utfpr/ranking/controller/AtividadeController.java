package utfpr.ranking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utfpr.ranking.model.Atividade;
import utfpr.ranking.service.CadastroAtividadeService;

@Controller
public class AtividadeController {

	@Autowired
	private CadastroAtividadeService atividadeService;
	
	@RequestMapping(value = "/atividade/novo",method = RequestMethod.GET)
	public ModelAndView cadastroAtividade(Atividade atividade){
		ModelAndView mv = new ModelAndView("cadastro-atividade");
		
		return mv;
	}
	
	@RequestMapping(value = "/atividade/novo", method = RequestMethod.POST)
	public ModelAndView cadastrarAtividade(@Valid Atividade atividade,BindingResult result, RedirectAttributes attr){
		if(result.hasErrors()){
			return cadastroAtividade(atividade);
		}
		atividadeService.salvar(atividade);
		attr.addFlashAttribute("mensagem", "Atividade cadastrada com sucesso");
		return new ModelAndView("redirect:/cadastro-atividade");
	}
	
	@RequestMapping(value="/atividade/novo-66", method=RequestMethod.POST, consumes= {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<?> salvarNovo66(@RequestBody Atividade atividade){
		Atividade ret = atividadeService.salvar(atividade);
		return ResponseEntity.ok(ret);
//		return ResponseEntity.badRequest().body("Erro salvando atividade");
	}
}
