package utfpr.ranking.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import utfpr.ranking.repository.Alunos;
import utfpr.ranking.repository.Designacoes;
import utfpr.ranking.repository.Professores;

@Controller
public class IndexController {

	@Autowired
	private Professores professores;
	
	@Autowired
	private Alunos alunos;
	
	@Autowired
	private Designacoes designacoes;
	
	@RequestMapping(value="/")
	public ModelAndView redirecionar(){
		return new ModelAndView("redirect:/index");
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("professoresCadastrados", professores.count());
		mv.addObject("alunosCadastrados", alunos.count());
		mv.addObject("designacoes", designacoes.count());
		return mv;
	}
	
	@RequestMapping(value="/relatorio",method = RequestMethod.GET)
	public ModelAndView ranking(){
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("format", "pdf");
		return new ModelAndView("ranking_professor", parametros);
	}
	
}
