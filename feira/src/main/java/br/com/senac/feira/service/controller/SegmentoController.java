package br.com.senac.feira.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.Segmento;
import br.com.senac.feira.service.SegmentoServiceImpl;
import br.com.senac.feira.service.SegmentoUsuarioServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("feira/segmento")
public class SegmentoController {

	@Autowired
	private SegmentoServiceImpl segmentoServiceImpl;

	@Autowired
	private SegmentoUsuarioServiceImpl segmentoUsuarioServiceImpl;

	@GetMapping("/segmentos")
	public ModelAndView listaSegmento() {
		ModelAndView mv = new ModelAndView("segmento/tabelaSegmento");
		mv.addObject("segmentos", segmentoServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraSegmento")
	public ModelAndView formCadastraSegmento() {
		ModelAndView mv = new ModelAndView("segmento/formSegmento");
		mv.addObject("segmentoUsuarios", segmentoUsuarioServiceImpl.searchAll());
		mv.addObject("segmento", new Segmento());
		return mv;
	}

	@GetMapping("/alteraSegmento/{id}")
	public ModelAndView alteraSegmento(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("segmento/alteraSegmento");
		mv.addObject("segmentoUsuarios", segmentoUsuarioServiceImpl.searchAll());
		mv.addObject("segmento", segmentoServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaSegmento")
	public ModelAndView alteraSalvaSegmento(Segmento segmento) throws ObjectNotFoundException {
		segmentoServiceImpl.edit(segmento);
		return listaSegmento();
	}

	@PostMapping("/salvaSegmento")
	public ModelAndView salvaSegmento(Segmento segmento) {
		segmentoServiceImpl.save(segmento);
		return listaSegmento();
	}
}