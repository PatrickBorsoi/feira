package br.com.senac.feira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.Empresa;
import br.com.senac.feira.service.EmpresaServiceImpl;
import br.com.senac.feira.service.ResponsavelServiceImpl;
import br.com.senac.feira.service.VagaServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("empresa")
public class EmpresaController {

	@Autowired
	private EmpresaServiceImpl empresaServiceImpl;

	@Autowired
	private ResponsavelServiceImpl responsavelServiceImpl;

	@Autowired
	private VagaServiceImpl vagaServiceImpl;

	@GetMapping("/empresas")
	public ModelAndView listaEmpresa() {
		ModelAndView mv = new ModelAndView("empresa/tabelaEmpresa");
		mv.addObject("empresas", empresaServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraEmpresa")
	public ModelAndView formCadastraEmpresa() {
		ModelAndView mv = new ModelAndView("empresa/formEmpresa");
		mv.addObject("responsaveis", responsavelServiceImpl.searchAll());
		mv.addObject("vagas", vagaServiceImpl.searchAll());
		mv.addObject("empresa", new Empresa());
		return mv;
	}

	@GetMapping("/alteraEmpresa/{id}")
	public ModelAndView alteraEmpresa(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("empresa/alteraEmpresa");
		mv.addObject("vagas", vagaServiceImpl.searchAll());
		mv.addObject("empresa", empresaServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaEmpresa")
	public ModelAndView alteraSalvaEmpresa(Empresa empresa) throws ObjectNotFoundException {
		empresaServiceImpl.edit(empresa);
		return listaEmpresa();
	}

	@PostMapping("/salvaEmpresa")
	public ModelAndView salvaEmpresa(Empresa empresa) {
		empresaServiceImpl.save(empresa);
		return listaEmpresa();
	}
}