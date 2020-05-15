package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.Stand;
import br.com.senac.feira.repository.StandRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class StandServiceImpl implements StandService {

	@Autowired
	StandRepository repository;

	public Stand search(Integer id) throws ObjectNotFoundException {
		Optional<Stand> stand = repository.findById(id);

		return stand.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Stand.class.getName()));
	}

	public List<Stand> searchAll() {
		return repository.findAll();
	}

	public Stand save(Stand stand) {
		return repository.save(stand);
	}

	public Stand edit(Stand stand) throws ObjectNotFoundException {
		Stand standAntigo = search(stand.getStand_id());
		standAntigo.setStand_nome(stand.getStand_nome());
		standAntigo.setStand_link_apresentacao(stand.getStand_link_apresentacao());
		standAntigo.setStand_link_chat(stand.getStand_link_chat());
		standAntigo.setStand_link_logomarca(stand.getStand_link_logomarca());
		standAntigo.setStand_status(stand.getStand_status());
		standAntigo.setEmpresa(stand.getEmpresa());
		standAntigo.setEventos(stand.getEventos());
		return save(standAntigo);
	}
}