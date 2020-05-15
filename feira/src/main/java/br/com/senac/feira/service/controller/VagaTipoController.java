package br.com.senac.feira.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.VagaTipo;
import br.com.senac.feira.service.VagaTipoServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("vagaTipo")
public class VagaTipoController {

	@Autowired
	private VagaTipoServiceImpl vagaTipoServiceImpl;

	@GetMapping("/vagaTipos")
	public ModelAndView listaVagaTipo() {
		ModelAndView mv = new ModelAndView("vagaTipo/tabelaVagaTipo");
		mv.addObject("vagaTipos", vagaTipoServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraVagaTipo")
	public ModelAndView formCadastraVagaTipo() {
		ModelAndView mv = new ModelAndView("vagaTipo/formVagaTipo");
		mv.addObject("vagaTipo", new VagaTipo());
		return mv;
	}

	@GetMapping("/alteraVagaTipo/{id}")
	public ModelAndView alteraVagaTipo(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("vagaTipo/alteraVagaTipo");
		mv.addObject("vagaTipo", vagaTipoServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaVagaTipo")
	public ModelAndView alteraSalvaVagaTipo(VagaTipo vagaTipo) throws ObjectNotFoundException {
		vagaTipoServiceImpl.edit(vagaTipo);
		return listaVagaTipo();
	}

	@PostMapping("/salvaVagaTipo")
	public ModelAndView salvaVagaTipo(VagaTipo vagaTipo) {
		vagaTipoServiceImpl.save(vagaTipo);
		return listaVagaTipo();
	}
}