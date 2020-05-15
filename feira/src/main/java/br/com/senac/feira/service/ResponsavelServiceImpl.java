package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.Responsavel;
import br.com.senac.feira.repository.ResponsavelRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ResponsavelServiceImpl implements ResponsavelService {

	@Autowired
	ResponsavelRepository repository;

	public Responsavel search(Integer id) throws ObjectNotFoundException {
		Optional<Responsavel> responsavel = repository.findById(id);

		return responsavel.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + Responsavel.class.getName()));
	}

	public List<Responsavel> searchAll() {
		return repository.findAll();
	}

	public Responsavel save(Responsavel responsavel) {
		return repository.save(responsavel);
	}

	public Responsavel edit(Responsavel responsavel) throws ObjectNotFoundException {
		Responsavel responsavelAntiga = search(responsavel.getResponsavel_id());
		responsavelAntiga.setResponsavel_nome_completo(responsavel.getResponsavel_nome_completo());
		responsavelAntiga.setResponsavel_usuario(responsavel.getResponsavel_usuario());
		responsavelAntiga.setResponsavel_senha(responsavel.getResponsavel_senha());
		responsavelAntiga.setResponsavel_email(responsavel.getResponsavel_email());
		responsavelAntiga.setResponsavel_telefone(responsavel.getResponsavel_telefone());
		responsavelAntiga.setResponsavel_status(responsavel.getResponsavel_status());
		responsavelAntiga.setEmpresa(responsavel.getEmpresa());
		return save(responsavelAntiga);
	}
}