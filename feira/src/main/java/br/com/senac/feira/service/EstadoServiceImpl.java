package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.Estado;
import br.com.senac.feira.repository.EstadoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	EstadoRepository repository;

	public Estado search(Integer id) throws ObjectNotFoundException {
		Optional<Estado> estado = repository.findById(id);

		return estado.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Estado.class.getName()));
	}

	public List<Estado> searchAll() {
		return repository.findAll();
	}

	public Estado save(Estado estado) {
		return repository.save(estado);
	}

	public Estado edit(Estado estado) throws ObjectNotFoundException {
		Estado estadoAntigo = search(estado.getEstado_id());
		estadoAntigo.setEstado_nome(estado.getEstado_nome());
		estadoAntigo.setEstado_Status(estado.getEstado_Status());
		estadoAntigo.setCidades(estado.getCidades());
		return save(estadoAntigo);
	}
}