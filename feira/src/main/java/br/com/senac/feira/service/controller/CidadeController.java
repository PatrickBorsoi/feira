package br.com.senac.feira.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.Cidade;
import br.com.senac.feira.service.BairroServiceImpl;
import br.com.senac.feira.service.CidadeServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("feira/cidade")
public class CidadeController {

	@Autowired
	private CidadeServiceImpl cidadeServiceImpl;

	@Autowired
	private BairroServiceImpl bairroServiceImpl;

	@GetMapping("/cidades")
	public ModelAndView listaCidade() {
		ModelAndView mv = new ModelAndView("cidade/tabelaCidade");
		mv.addObject("cidades", cidadeServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraCidade")
	public ModelAndView formCadastraCidade() {
		ModelAndView mv = new ModelAndView("cidade/formCidade");
		mv.addObject("bairros", bairroServiceImpl.searchAll());
		mv.addObject("cidade", new Cidade());
		return mv;
	}

	@GetMapping("/alteraCidade/{id}")
	public ModelAndView alteraCidade(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("cidade/alteraCidade");
		mv.addObject("bairros", bairroServiceImpl.searchAll());
		mv.addObject("cidade", cidadeServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaCidade")
	public ModelAndView alteraSalvaCidade(Cidade cidade) throws ObjectNotFoundException {
		cidadeServiceImpl.edit(cidade);
		return listaCidade();
	}

	@PostMapping("/salvaCidade")
	public ModelAndView salvaCidade(Cidade cidade) {
		cidadeServiceImpl.save(cidade);
		return listaCidade();
	}
}