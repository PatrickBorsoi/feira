package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.Usuario;
import javassist.tools.rmi.ObjectNotFoundException;

public interface UsuarioService {

	Usuario search(Integer id) throws ObjectNotFoundException;

	List<Usuario> searchAll();

	Usuario save(Usuario usuario);

	Usuario edit(Usuario usuario) throws ObjectNotFoundException;
}