package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.Usuario;
import br.com.senac.feira.repository.UsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository repository;

	public Usuario search(Integer id) throws ObjectNotFoundException {
		Optional<Usuario> usuario = repository.findById(id);

		return usuario.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Usuario.class.getName()));
	}

	public List<Usuario> searchAll() {
		return repository.findAll();
	}

	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	public Usuario edit(Usuario usuario) throws ObjectNotFoundException {
		Usuario usuarioAntigo = search(usuario.getUsuario_id());
		usuarioAntigo.setUsuario_nome_completo(usuario.getUsuario_nome_completo());
		usuarioAntigo.setUsuario_cpf(usuario.getUsuario_cpf());
		usuarioAntigo.setUsuario_politica_lgpd(usuario.getUsuario_politica_lgpd());
		usuarioAntigo.setUsuario_politica_lgpd_versao(usuario.getUsuario_politica_lgpd_versao());
		usuarioAntigo.setUsuario_status(usuario.getUsuario_status());
		usuarioAntigo.setSegmentoUsuarios(usuario.getSegmentoUsuarios());
		usuarioAntigo.setCandidaturas(usuario.getCandidaturas());
		usuarioAntigo.setCurriculos(usuario.getCurriculos());
		return save(usuarioAntigo);
	}
}