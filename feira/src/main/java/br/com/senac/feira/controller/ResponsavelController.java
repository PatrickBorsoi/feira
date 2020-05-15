package br.com.senac.feira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.Responsavel;
import br.com.senac.feira.service.ResponsavelServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("responsavel")
public class ResponsavelController {

	@Autowired
	private ResponsavelServiceImpl responsavelServiceImpl;

	@GetMapping("responsaveis")
	public ModelAndView listaResponsavel() {
		ModelAndView mv = new ModelAndView("responsavel/tabelaResponsavel");
		mv.addObject("responsaveis", responsavelServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("cadastraResponsavel")
	public ModelAndView formCadastraResponsavel() {
		ModelAndView mv = new ModelAndView("responsavel/formResponsavel");
		mv.addObject("responsavel", new Responsavel());
		return mv;
	}

	@GetMapping("alteraResponsavel/{id}")
	public ModelAndView alteraResponsavel(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("responsavel/alteraResponsavel");
		mv.addObject("responsavel", responsavelServiceImpl.search(id));
		return mv;
	}

	@GetMapping("alteraSalvaResponsavel")
	public ModelAndView alteraSalvaResponsavel(Responsavel responsavel) throws ObjectNotFoundException {
		responsavelServiceImpl.edit(responsavel);
		return listaResponsavel();
	}

	@PostMapping("salvaResponsavel")
	public ModelAndView salvaResponsavel(Responsavel responsavel) {
		responsavelServiceImpl.save(responsavel);
		return listaResponsavel();
	}
}