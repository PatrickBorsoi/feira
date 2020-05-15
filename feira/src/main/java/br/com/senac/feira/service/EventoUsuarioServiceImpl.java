package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.EventoUsuario;
import br.com.senac.feira.repository.EventoUsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EventoUsuarioServiceImpl implements EventoUsuarioService {

	@Autowired
	EventoUsuarioRepository repository;

	public EventoUsuario search(Integer id) throws ObjectNotFoundException {
		Optional<EventoUsuario> eventoUsuario = repository.findById(id);

		return eventoUsuario.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + EventoUsuario.class.getName()));
	}

	public List<EventoUsuario> searchAll() {
		return repository.findAll();
	}

	public EventoUsuario save(EventoUsuario eventoUsuario) {
		return repository.save(eventoUsuario);
	}

	public EventoUsuario edit(EventoUsuario eventoUsuario) throws ObjectNotFoundException {
		EventoUsuario eventoUsuarioAntigo = search(eventoUsuario.getEvento_usuario_id());
		eventoUsuarioAntigo.setEvento_usuario_data_registro(eventoUsuario.getEvento_usuario_data_registro());
		eventoUsuarioAntigo.setEvento_usuario_link_certificado(eventoUsuario.getEvento_usuario_link_certificado());
		eventoUsuarioAntigo.setEvento_usuario_status(eventoUsuario.getEvento_usuario_status());
		eventoUsuarioAntigo.setUsuario(eventoUsuario.getUsuario());
		eventoUsuarioAntigo.setEvento(eventoUsuario.getEvento());
		return save(eventoUsuarioAntigo);
	}
}