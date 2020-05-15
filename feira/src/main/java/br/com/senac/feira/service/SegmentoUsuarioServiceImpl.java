package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.SegmentoUsuario;
import br.com.senac.feira.repository.SegmentoUsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class SegmentoUsuarioServiceImpl implements SegmentoUsuarioService {

	@Autowired
	SegmentoUsuarioRepository repository;

	public SegmentoUsuario search(Integer id) throws ObjectNotFoundException {
		Optional<SegmentoUsuario> segmentoUsuario = repository.findById(id);

		return segmentoUsuario.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + SegmentoUsuario.class.getName()));
	}

	public List<SegmentoUsuario> searchAll() {
		return repository.findAll();
	}

	public SegmentoUsuario save(SegmentoUsuario segmentoUsuario) {
		return repository.save(segmentoUsuario);
	}

	public SegmentoUsuario edit(SegmentoUsuario segmentoUsuario) throws ObjectNotFoundException {
		SegmentoUsuario segmentoUsuarioAntigo = search(segmentoUsuario.getSegmento_usuario_id());
		segmentoUsuarioAntigo.setUsuario(segmentoUsuario.getUsuario());
		segmentoUsuarioAntigo.setSegmento(segmentoUsuario.getSegmento());
		return save(segmentoUsuarioAntigo);
	}
}