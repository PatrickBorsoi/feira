package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.Curriculo;
import br.com.senac.feira.repository.CurriculoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CurriculoServiceImpl implements CurriculoService {

	@Autowired
	CurriculoRepository repository;

	public Curriculo search(Integer id) throws ObjectNotFoundException {
		Optional<Curriculo> curriculo = repository.findById(id);

		return curriculo.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Curriculo.class.getName()));
	}

	public List<Curriculo> searchAll() {
		return repository.findAll();
	}

	public Curriculo save(Curriculo curriculo) {
		return repository.save(curriculo);
	}

	public Curriculo edit(Curriculo curriculo) throws ObjectNotFoundException {
		Curriculo curriculoAntigo = search(curriculo.getCurriculo_id());
		curriculoAntigo.setCurriculo_nome(curriculo.getCurriculo_nome());
		curriculoAntigo.setCurriculo_status(curriculo.getCurriculo_status());
		curriculoAntigo.setUsuario(curriculo.getUsuario());
		return save(curriculoAntigo);
	}
}