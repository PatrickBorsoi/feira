package br.com.senac.feira.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.Vaga;
import br.com.senac.feira.service.CandidaturaServiceImpl;
import br.com.senac.feira.service.VagaServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("feira/vaga")
public class VagaController {

	@Autowired
	private VagaServiceImpl vagaServiceImpl;

	@Autowired
	private CandidaturaServiceImpl candidaturaServiceImpl;

	@GetMapping("/vagas")
	public ModelAndView listaVaga() {
		ModelAndView mv = new ModelAndView("vaga/tabelaVaga");
		mv.addObject("vagas", vagaServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraVaga")
	public ModelAndView formCadastraVaga() {
		ModelAndView mv = new ModelAndView("vaga/formVaga");
		mv.addObject("candidaturas", candidaturaServiceImpl.searchAll());
		mv.addObject("vaga", new Vaga());
		return mv;
	}

	@GetMapping("/alteraVaga/{id}")
	public ModelAndView alteraVaga(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("vaga/alteraVaga");
		mv.addObject("candidaturas", candidaturaServiceImpl.searchAll());
		mv.addObject("vaga", vagaServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaVaga")
	public ModelAndView alteraSalvaVaga(Vaga vaga) throws ObjectNotFoundException {
		vagaServiceImpl.edit(vaga);
		return listaVaga();
	}

	@PostMapping("/salvaVaga")
	public ModelAndView salvaVaga(Vaga vaga) {
		vagaServiceImpl.save(vaga);
		return listaVaga();
	}
}