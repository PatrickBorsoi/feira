package br.com.senac.feira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.EventoUsuario;
import br.com.senac.feira.service.EventoUsuarioServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("eventoUsuario")
public class EventoUsuarioController {

	@Autowired
	private EventoUsuarioServiceImpl eventoUsuarioServiceImpl;

	@GetMapping("/eventoUsuarios")
	public ModelAndView listaEventoUsuario() {
		ModelAndView mv = new ModelAndView("eventoUsuario/tabelaEventoUsuario");
		mv.addObject("eventoUsuarios", eventoUsuarioServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraEventoUsuario")
	public ModelAndView formCadastraEventoUsuario() {
		ModelAndView mv = new ModelAndView("eventoUsuario/formEventoUsuario");
		mv.addObject("eventoUsuario", new EventoUsuario());
		return mv;
	}

	@GetMapping("/alteraEventoUsuario/{id}")
	public ModelAndView alteraEventoUsuario(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("eventoUsuario/alteraEventoUsuario");
		mv.addObject("eventoUsuario", eventoUsuarioServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaEventoUsuario")
	public ModelAndView alteraSalvaEventoUsuario(EventoUsuario eventoUsuario) throws ObjectNotFoundException {
		eventoUsuarioServiceImpl.edit(eventoUsuario);
		return listaEventoUsuario();
	}

	@PostMapping("/salvaEventoUsuario")
	public ModelAndView salvaEventoUsuario(EventoUsuario eventoUsuario) {
		eventoUsuarioServiceImpl.save(eventoUsuario);
		return listaEventoUsuario();
	}
}