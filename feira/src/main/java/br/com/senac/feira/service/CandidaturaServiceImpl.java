package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.Candidatura;
import br.com.senac.feira.repository.CandidaturaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CandidaturaServiceImpl implements CandidaturaService {

	@Autowired
	CandidaturaRepository repository;

	public Candidatura search(Integer id) throws ObjectNotFoundException {
		Optional<Candidatura> candidatura = repository.findById(id);

		return candidatura.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + Candidatura.class.getName()));
	}

	public List<Candidatura> searchAll() {
		return repository.findAll();
	}

	public Candidatura save(Candidatura candidatura) {
		return repository.save(candidatura);
	}

	public Candidatura edit(Candidatura candidatura) throws ObjectNotFoundException {
		Candidatura candidaturaAntiga = search(candidatura.getCandidatura_id());
		candidaturaAntiga.setCurriculo(candidatura.getCurriculo());
		candidaturaAntiga.setEtapaProcesso(candidatura.getEtapaProcesso());
		candidaturaAntiga.setUsuario(candidatura.getUsuario());
		candidaturaAntiga.setVaga(candidatura.getVaga());
		return save(candidaturaAntiga);
	}
}