package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.Segmento;
import br.com.senac.feira.repository.SegmentoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class SegmentoServiceImpl implements SegmentoService {

	@Autowired
	SegmentoRepository repository;

	public Segmento search(Integer id) throws ObjectNotFoundException {
		Optional<Segmento> segmento = repository.findById(id);

		return segmento.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Segmento.class.getName()));
	}

	public List<Segmento> searchAll() {
		return repository.findAll();
	}

	public Segmento save(Segmento segmento) {
		return repository.save(segmento);
	}

	public Segmento edit(Segmento segmento) throws ObjectNotFoundException {
		Segmento segmentoAntigo = search(segmento.getSegmento_id());
		segmentoAntigo.setSegmento_descricao(segmento.getSegmento_descricao());
		segmentoAntigo.setSegmento_Status(segmento.getSegmento_Status());
		segmentoAntigo.setSegmentoUsuarios(segmento.getSegmentoUsuarios());
		return save(segmentoAntigo);
	}
}