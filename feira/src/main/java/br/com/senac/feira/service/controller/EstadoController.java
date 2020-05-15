package br.com.senac.feira.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.Estado;
import br.com.senac.feira.service.CidadeServiceImpl;
import br.com.senac.feira.service.EstadoServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("feira/estado")
public class EstadoController {

	@Autowired
	private EstadoServiceImpl estadoServiceImpl;

	@Autowired
	private CidadeServiceImpl cidadeServiceImpl;

	@GetMapping("/estados")
	public ModelAndView listaEstado() {
		ModelAndView mv = new ModelAndView("estado/tabelaEstado");
		mv.addObject("estados", estadoServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraEstado")
	public ModelAndView formCadastraEstado() {
		ModelAndView mv = new ModelAndView("estado/formEstado");
		mv.addObject("cidades", cidadeServiceImpl.searchAll());
		mv.addObject("estado", new Estado());
		return mv;
	}

	@GetMapping("/alteraEstado/{id}")
	public ModelAndView alteraEstado(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("estado/alteraEstado");
		mv.addObject("cidades", cidadeServiceImpl.searchAll());
		mv.addObject("estado", estadoServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaEstado")
	public ModelAndView alteraSalvaEstado(Estado estado) throws ObjectNotFoundException {
		estadoServiceImpl.edit(estado);
		return listaEstado();
	}

	@PostMapping("/salvaEstado")
	public ModelAndView salvaEstado(Estado estado) {
		estadoServiceImpl.save(estado);
		return listaEstado();
	}
}