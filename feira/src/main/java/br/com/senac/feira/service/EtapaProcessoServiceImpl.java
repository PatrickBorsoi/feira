package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.EtapaProcesso;
import br.com.senac.feira.repository.EtapaProcessoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EtapaProcessoServiceImpl implements EtapaProcessoService {

	@Autowired
	EtapaProcessoRepository repository;

	public EtapaProcesso search(Integer id) throws ObjectNotFoundException {
		Optional<EtapaProcesso> etapaProcesso = repository.findById(id);

		return etapaProcesso.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + EtapaProcesso.class.getName()));
	}

	public List<EtapaProcesso> searchAll() {
		return repository.findAll();
	}

	public EtapaProcesso save(EtapaProcesso etapaProcesso) {
		return repository.save(etapaProcesso);
	}

	public EtapaProcesso edit(EtapaProcesso etapaProcesso) throws ObjectNotFoundException {
		EtapaProcesso etapaProcessoAntiga = search(etapaProcesso.getEtapa_processo_id());
		etapaProcessoAntiga.setEtapa_processo_descricao(etapaProcesso.getEtapa_processo_descricao());
		etapaProcessoAntiga.setEtapa_processo_Status(etapaProcesso.getEtapa_processo_Status());
		return save(etapaProcessoAntiga);
	}
}