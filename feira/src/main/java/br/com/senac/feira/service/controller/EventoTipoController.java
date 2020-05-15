package br.com.senac.feira.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.EventoTipo;
import br.com.senac.feira.service.EventoServiceImpl;
import br.com.senac.feira.service.EventoTipoServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("eventoTipo")
public class EventoTipoController {

	@Autowired
	private EventoTipoServiceImpl eventoTipoServiceImpl;

	@Autowired
	private EventoServiceImpl eventoServiceImpl;

	@GetMapping("/eventoTipos")
	public ModelAndView listaEventoTipo() {
		ModelAndView mv = new ModelAndView("eventoTipo/tabelaEventoTipo");
		mv.addObject("eventoTipos", eventoTipoServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraEventoTipo")
	public ModelAndView formCadastraEventoTipo() {
		ModelAndView mv = new ModelAndView("eventoTipo/formEventoTipo");
		mv.addObject("eventos", eventoServiceImpl.searchAll());
		mv.addObject("eventoTipo", new EventoTipo());
		return mv;
	}

	@GetMapping("/alteraEventoTipo/{id}")
	public ModelAndView alteraEventoTipo(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("eventoTipo/alteraEventoTipo");
		mv.addObject("eventos", eventoServiceImpl.searchAll());
		mv.addObject("eventoTipo", eventoTipoServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaEventoTipo")
	public ModelAndView alteraSalvaEventoTipo(EventoTipo eventoTipo) throws ObjectNotFoundException {
		eventoTipoServiceImpl.edit(eventoTipo);
		return listaEventoTipo();
	}

	@PostMapping("/salvaEventoTipo")
	public ModelAndView salvaEventoTipo(EventoTipo eventoTipo) {
		eventoTipoServiceImpl.save(eventoTipo);
		return listaEventoTipo();
	}
}