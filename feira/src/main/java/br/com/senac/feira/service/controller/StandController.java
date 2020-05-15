package br.com.senac.feira.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.Stand;
import br.com.senac.feira.service.EventoServiceImpl;
import br.com.senac.feira.service.StandServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("stand")
public class StandController {

	@Autowired
	private StandServiceImpl standServiceImpl;

	@Autowired
	private EventoServiceImpl eventoServiceImpl;

	@GetMapping("/stands")
	public ModelAndView listaStand() {
		ModelAndView mv = new ModelAndView("stand/tabelaStand");
		mv.addObject("stands", standServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraStand")
	public ModelAndView formCadastraStand() {
		ModelAndView mv = new ModelAndView("stand/formStand");
		mv.addObject("eventos", eventoServiceImpl.searchAll());
		mv.addObject("stand", new Stand());
		return mv;
	}

	@GetMapping("/alteraStand/{id}")
	public ModelAndView alteraStand(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("stand/alteraStand");
		mv.addObject("eventos", eventoServiceImpl.searchAll());
		mv.addObject("stand", standServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaStand")
	public ModelAndView alteraSalvaStand(Stand stand) throws ObjectNotFoundException {
		standServiceImpl.edit(stand);
		return listaStand();
	}

	@PostMapping("/salvaStand")
	public ModelAndView salvaStand(Stand stand) {
		standServiceImpl.save(stand);
		return listaStand();
	}
}