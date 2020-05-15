package br.com.senac.feira.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.AreaAtuacao;
import br.com.senac.feira.service.AreaAtuacaoServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("areaAtuacao")
public class AreaAtuacaoController {

	@Autowired
	private AreaAtuacaoServiceImpl areaAtuacaoServiceImpl;

	@GetMapping("/areaAtuacaos")
	public ModelAndView listaAreaAtuacao() {
		ModelAndView mv = new ModelAndView("areaAtuacao/tabelaAreaAtuacao");
		mv.addObject("areaAtuacaos", areaAtuacaoServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraAreaAtuacao")
	public ModelAndView formCadastraAreaAtuacao() {
		ModelAndView mv = new ModelAndView("areaAtuacao/formAreaAtuacao");
		mv.addObject("areaAtuacao", new AreaAtuacao());
		return mv;
	}

	@GetMapping("/alteraAreaAtuacao/{id}")
	public ModelAndView alteraAreaAtuacao(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("areaAtuacao/alteraAreaAtuacao");
		mv.addObject("areaAtuacao", areaAtuacaoServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaAreaAtuacao")
	public ModelAndView alteraSalvaAreaAtuacao(AreaAtuacao areaAtuacao) throws ObjectNotFoundException {
		areaAtuacaoServiceImpl.edit(areaAtuacao);
		return listaAreaAtuacao();
	}

	@PostMapping("/salvaAreaAtuacao")
	public ModelAndView salvaAreaAtuacao(AreaAtuacao areaAtuacao) {
		areaAtuacaoServiceImpl.save(areaAtuacao);
		return listaAreaAtuacao();
	}
}