package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.VagaTipo;
import br.com.senac.feira.repository.VagaTipoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class VagaTipoServiceImpl implements VagaTipoService {

	@Autowired
	VagaTipoRepository repository;

	public VagaTipo search(Integer id) throws ObjectNotFoundException {
		Optional<VagaTipo> vaga_tipo = repository.findById(id);

		return vaga_tipo.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + VagaTipo.class.getName()));
	}

	public List<VagaTipo> searchAll() {
		return repository.findAll();
	}

	public VagaTipo save(VagaTipo vaga_tipo) {
		return repository.save(vaga_tipo);
	}

	public VagaTipo edit(VagaTipo vaga_tipo) throws ObjectNotFoundException {
		VagaTipo vaga_tipoAntiga = search(vaga_tipo.getVaga_tipo_id());
		vaga_tipoAntiga.setVaga_tipo_descricao(vaga_tipo.getVaga_tipo_descricao());
		vaga_tipoAntiga.setVaga_tipo_status(vaga_tipo.getVaga_tipo_status());
		return save(vaga_tipoAntiga);
	}
}