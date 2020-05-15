package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.EventoTipo;
import br.com.senac.feira.repository.EventoTipoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EventoTipoServiceImpl implements EventoTipoService {

	@Autowired
	EventoTipoRepository repository;

	public EventoTipo search(Integer id) throws ObjectNotFoundException {
		Optional<EventoTipo> eventoTipo = repository.findById(id);

		return eventoTipo.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + EventoTipo.class.getName()));
	}

	public List<EventoTipo> searchAll() {
		return repository.findAll();
	}

	public EventoTipo save(EventoTipo eventoTipo) {
		return repository.save(eventoTipo);
	}

	public EventoTipo edit(EventoTipo eventoTipo) throws ObjectNotFoundException {
		EventoTipo eventoTipoAntiga = search(eventoTipo.getEvento_tipo_id());
		eventoTipoAntiga.setEvento_tipo_descricao(eventoTipo.getEvento_tipo_descricao());
		eventoTipoAntiga.setEvento_tipo_status(eventoTipo.getEvento_tipo_status());
		eventoTipo.setEventos(eventoTipo.getEventos());
		return save(eventoTipoAntiga);
	}
}