package br.com.senac.feira.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.SegmentoUsuario;
import br.com.senac.feira.service.SegmentoUsuarioServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("feira/segmentoUsuario")
public class SegmentoUsuarioController {

	@Autowired
	private SegmentoUsuarioServiceImpl segmentoUsuarioServiceImpl;

	@GetMapping("/segmentoUsuarios")
	public ModelAndView listaSegmentoUsuario() {
		ModelAndView mv = new ModelAndView("segmentoUsuario/tabelaSegmentoUsuario");
		mv.addObject("segmentoUsuarios", segmentoUsuarioServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraSegmentoUsuario")
	public ModelAndView formCadastraSegmentoUsuario() {
		ModelAndView mv = new ModelAndView("segmentoUsuario/formSegmentoUsuario");
		mv.addObject("segmentoUsuario", new SegmentoUsuario());
		return mv;
	}

	@GetMapping("/alteraSegmentoUsuario/{id}")
	public ModelAndView alteraSegmentoUsuario(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("segmentoUsuario/alteraSegmentoUsuario");
		mv.addObject("segmentoUsuario", segmentoUsuarioServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaSegmentoUsuario")
	public ModelAndView alteraSalvaSegmentoUsuario(SegmentoUsuario segmentoUsuario) throws ObjectNotFoundException {
		segmentoUsuarioServiceImpl.edit(segmentoUsuario);
		return listaSegmentoUsuario();
	}

	@PostMapping("/salvaSegmentoUsuario")
	public ModelAndView salvaSegmentoUsuario(SegmentoUsuario segmentoUsuario) {
		segmentoUsuarioServiceImpl.save(segmentoUsuario);
		return listaSegmentoUsuario();
	}
}