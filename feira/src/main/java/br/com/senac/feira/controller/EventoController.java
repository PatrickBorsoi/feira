package br.com.senac.feira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.Evento;
import br.com.senac.feira.service.EventoServiceImpl;
import br.com.senac.feira.service.EventoUsuarioServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("evento")
public class EventoController {

	@Autowired
	private EventoServiceImpl eventoServiceImpl;
	
	@Autowired
	private EventoUsuarioServiceImpl eventoUsuarioServiceImpl;

	@GetMapping("/eventos")
	public ModelAndView listaEvento() {
		ModelAndView mv = new ModelAndView("evento/tabelaEvento");
		mv.addObject("eventos", eventoServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraEvento")
	public ModelAndView formCadastraEvento() {
		ModelAndView mv = new ModelAndView("evento/formEvento");
		mv.addObject("eventoUsuarios", eventoUsuarioServiceImpl.searchAll());
		mv.addObject("evento", new Evento());
		return mv;
	}

	@GetMapping("/alteraEvento/{id}")
	public ModelAndView alteraEvento(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("evento/alteraEvento");
		mv.addObject("eventoUsuarios", eventoUsuarioServiceImpl.searchAll());
		mv.addObject("evento", eventoServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaEvento")
	public ModelAndView alteraSalvaEvento(Evento evento) throws ObjectNotFoundException {
		eventoServiceImpl.edit(evento);
		return listaEvento();
	}

	@PostMapping("/salvaEvento")
	public ModelAndView salvaEvento(Evento evento) {
		eventoServiceImpl.save(evento);
		return listaEvento();
	}
}