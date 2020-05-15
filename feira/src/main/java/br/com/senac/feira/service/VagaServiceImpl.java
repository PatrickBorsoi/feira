package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.Vaga;
import br.com.senac.feira.repository.VagaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class VagaServiceImpl implements VagaService {

	@Autowired
	VagaRepository repository;

	public Vaga search(Integer id) throws ObjectNotFoundException {
		Optional<Vaga> vaga = repository.findById(id);

		return vaga.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Vaga.class.getName()));
	}

	public List<Vaga> searchAll() {
		return repository.findAll();
	}

	public Vaga save(Vaga vaga) {
		return repository.save(vaga);
	}

	public Vaga edit(Vaga vaga) throws ObjectNotFoundException {
		Vaga vagaAntiga = search(vaga.getVaga_id());
		vagaAntiga.setVaga_senac(vaga.getVaga_senac());
		vagaAntiga.setVaga_codigo_senac(vaga.getVaga_codigo_senac());
		vagaAntiga.setVaga_url_vaga(vaga.getVaga_url_vaga());
		vagaAntiga.setVaga_cargo(vaga.getVaga_cargo());
		vagaAntiga.setVaga_descricao(vaga.getVaga_descricao());
		vagaAntiga.setVaga_quantidade(vaga.getVaga_quantidade());
		vagaAntiga.setVaga_remuneracao(vaga.getVaga_remuneracao());
		vagaAntiga.setVaga_requisitos(vaga.getVaga_requisitos());
		vagaAntiga.setVaga_atividades_principais(vaga.getVaga_atividades_principais());
		vagaAntiga.setVaga_beneficios(vaga.getVaga_beneficios());
		vagaAntiga.setVaga_observacoes(vaga.getVaga_observacoes());
		vagaAntiga.setVaga_disponibilidade_inicio(vaga.getVaga_disponibilidade_inicio());
		vagaAntiga.setVaga_disponibilidade_fim(vaga.getVaga_disponibilidade_fim());
		vagaAntiga.setVaga_status(vaga.getVaga_status());
		vagaAntiga.setAreaAtuacao(vaga.getAreaAtuacao());
		vagaAntiga.setBairro(vaga.getBairro());
		vagaAntiga.setCidade(vaga.getCidade());
		vagaAntiga.setEmpresa(vaga.getEmpresa());
		vagaAntiga.setEstado(vaga.getEstado());
		vagaAntiga.setSegmento(vaga.getSegmento());
		vagaAntiga.setVagaTipo(vaga.getVagaTipo());
		vagaAntiga.setCandidaturas(vaga.getCandidaturas());
		return save(vagaAntiga);
	}
}