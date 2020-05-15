package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.Bairro;
import br.com.senac.feira.repository.BairroRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class BairroServiceImpl implements BairroService {

	@Autowired
	BairroRepository repository;

	public Bairro search(Integer id) throws ObjectNotFoundException {
		Optional<Bairro> bairro = repository.findById(id);

		return bairro.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Bairro.class.getName()));
	}

	public List<Bairro> searchAll() {
		return repository.findAll();
	}

	public Bairro save(Bairro bairro) {
		return repository.save(bairro);
	}

	public Bairro edit(Bairro bairro) throws ObjectNotFoundException {
		Bairro bairroAntigo = search(bairro.getBairro_id());
		bairroAntigo.setBairro_nome(bairro.getBairro_nome());
		bairroAntigo.setBairro_status(bairro.getBairro_status());
		bairroAntigo.setCidade(bairro.getCidade());
		return save(bairroAntigo);
	}
}