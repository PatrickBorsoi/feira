package br.com.senac.feira.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.feira.model.Usuario;
import br.com.senac.feira.service.CandidaturaServiceImpl;
import br.com.senac.feira.service.CurriculoServiceImpl;
import br.com.senac.feira.service.EventoUsuarioServiceImpl;
import br.com.senac.feira.service.SegmentoUsuarioServiceImpl;
import br.com.senac.feira.service.UsuarioServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("feira/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;

	@Autowired
	private CandidaturaServiceImpl candidaturaServiceImpl;

	@Autowired
	private CurriculoServiceImpl curriculoServiceImpl;

	@Autowired
	private EventoUsuarioServiceImpl eventoUsuarioServiceImpl;

	@Autowired
	private SegmentoUsuarioServiceImpl segmentoUsuarioServiceImpl;

	@GetMapping("/usuarios")
	public ModelAndView listaUsuario() {
		ModelAndView mv = new ModelAndView("usuario/tabelaUsuario");
		mv.addObject("usuarios", usuarioServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraUsuario")
	public ModelAndView formCadastraUsuario() {
		ModelAndView mv = new ModelAndView("usuario/formUsuario");
		mv.addObject("candidaturas", candidaturaServiceImpl.searchAll());
		mv.addObject("curriculos", curriculoServiceImpl.searchAll());
		mv.addObject("eventoUsuarios", eventoUsuarioServiceImpl.searchAll());
		mv.addObject("segmentoUsuarios", segmentoUsuarioServiceImpl.searchAll());
		mv.addObject("usuario", new Usuario());
		return mv;
	}

	@GetMapping("/alteraUsuario/{id}")
	public ModelAndView alteraUsuario(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("usuario/alteraUsuario");
		mv.addObject("candidaturas", candidaturaServiceImpl.searchAll());
		mv.addObject("curriculos", curriculoServiceImpl.searchAll());
		mv.addObject("eventoUsuarios", eventoUsuarioServiceImpl.searchAll());
		mv.addObject("segmentoUsuarios", segmentoUsuarioServiceImpl.searchAll());
		mv.addObject("usuario", usuarioServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraSalvaUsuario")
	public ModelAndView alteraSalvaUsuario(Usuario usuario) throws ObjectNotFoundException {
		usuarioServiceImpl.edit(usuario);
		return listaUsuario();
	}

	@PostMapping("/salvaUsuario")
	public ModelAndView salvaUsuario(Usuario usuario) {
		usuarioServiceImpl.save(usuario);
		return listaUsuario();
	}
}