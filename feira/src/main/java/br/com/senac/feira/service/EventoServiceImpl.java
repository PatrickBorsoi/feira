package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.Evento;
import br.com.senac.feira.repository.EventoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	EventoRepository repository;

	public Evento search(Integer id) throws ObjectNotFoundException {
		Optional<Evento> evento = repository.findById(id);

		return evento.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Evento.class.getName()));
	}

	public List<Evento> searchAll() {
		return repository.findAll();
	}

	public Evento save(Evento evento) {
		return repository.save(evento);
	}

	public Evento edit(Evento evento) throws ObjectNotFoundException {
		Evento eventoAntigo = search(evento.getEvento_id());
		eventoAntigo.setEvento_titulo(evento.getEvento_titulo());
		eventoAntigo.setEvento_link_evento(evento.getEvento_link_evento());
		eventoAntigo.setEvento_data_inicio(evento.getEvento_data_inicio());
		eventoAntigo.setEvento_data_fim(evento.getEvento_data_fim());
		eventoAntigo.setEvento_link_banner(evento.getEvento_link_banner());
		eventoAntigo.setEvento_vagas(evento.getEvento_vagas());
		eventoAntigo.setEvento_status(evento.getEvento_status());
		eventoAntigo.setEventoTipo(evento.getEventoTipo());
		eventoAntigo.setStand(evento.getStand());
		eventoAntigo.setEventoUsuarios(evento.getEventoUsuarios());
		return save(eventoAntigo);
	}
}