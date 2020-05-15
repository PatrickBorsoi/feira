package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.EventoUsuario;
import javassist.tools.rmi.ObjectNotFoundException;

public interface EventoUsuarioService {

	EventoUsuario search(Integer id) throws ObjectNotFoundException;

	List<EventoUsuario> searchAll();

	EventoUsuario save(EventoUsuario eventoUsuario);

	EventoUsuario edit(EventoUsuario eventoUsuario) throws ObjectNotFoundException;
}