package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.AreaAtuacao;
import br.com.senac.feira.repository.AreaAtuacaoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AreaAtuacaoServiceImpl implements AreaAtuacaoService {

	@Autowired
	AreaAtuacaoRepository repository;

	public AreaAtuacao search(Integer id) throws ObjectNotFoundException {
		Optional<AreaAtuacao> Area_atuacao = repository.findById(id);

		return Area_atuacao.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + AreaAtuacao.class.getName()));
	}

	public List<AreaAtuacao> searchAll() {
		return repository.findAll();
	}

	public AreaAtuacao save(AreaAtuacao area_atuacao) {
		return repository.save(area_atuacao);
	}

	public AreaAtuacao edit(AreaAtuacao area_atuacao) throws ObjectNotFoundException {
		AreaAtuacao area_atuacaoAntiga = search(area_atuacao.getArea_atuacao_id());
		area_atuacaoAntiga.setArea_atuacao_descricao(area_atuacao.getArea_atuacao_descricao());
		area_atuacaoAntiga.setArea_atuacao_status(area_atuacao.getArea_atuacao_status());
		return save(area_atuacaoAntiga);
	}
}