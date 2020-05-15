package br.com.senac.feira.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.Bairro;
import br.com.senac.feira.service.BairroServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("bairro")
public class BairroController {

	@Autowired
	private BairroServiceImpl bairroServiceImpl;

	@GetMapping("/bairros")
	public ModelAndView listaBairro() {
		ModelAndView mv = new ModelAndView("bairro/tabelaBairro");
		mv.addObject("bairros", bairroServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraBairro")
	public ModelAndView formCadastraBairro() {
		ModelAndView mv = new ModelAndView("bairro/formBairro");
		mv.addObject("bairro", new Bairro());
		return mv;
	}

	@GetMapping("/alteraBairro/{id}")
	public ModelAndView alteraBairro(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("bairro/alteraBairro");
		mv.addObject("bairro", bairroServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaBairro")
	public ModelAndView alteraSalvaBairro(Bairro bairro) throws ObjectNotFoundException {
		bairroServiceImpl.edit(bairro);
		return listaBairro();
	}

	@PostMapping("/salvaBairro")
	public ModelAndView salvaBairro(Bairro bairro) {
		bairroServiceImpl.save(bairro);
		return listaBairro();
	}
}