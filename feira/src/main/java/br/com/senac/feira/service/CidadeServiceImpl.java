package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.Cidade;
import br.com.senac.feira.repository.CidadeRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CidadeServiceImpl implements CidadeService {

	@Autowired
	CidadeRepository repository;

	public Cidade search(Integer id) throws ObjectNotFoundException {
		Optional<Cidade> cidade = repository.findById(id);

		return cidade.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Cidade.class.getName()));
	}

	public List<Cidade> searchAll() {
		return repository.findAll();
	}

	public Cidade save(Cidade cidade) {
		return repository.save(cidade);
	}

	public List<Cidade> saveAll(List<Cidade> cidades) {
		return repository.saveAll(cidades);
	}

	public Cidade edit(Cidade cidade) throws ObjectNotFoundException {
		Cidade cidadeAntiga = search(cidade.getCidade_id());
		cidadeAntiga.setCidade_nome(cidade.getCidade_nome());
		cidadeAntiga.setCidade_status(cidade.getCidade_status());
		cidadeAntiga.setEstado(cidade.getEstado());
		cidade.setBairros(cidade.getBairros());
		return save(cidadeAntiga);
	}
}