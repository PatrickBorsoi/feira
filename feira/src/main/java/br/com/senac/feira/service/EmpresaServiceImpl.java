package br.com.senac.feira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.feira.model.Empresa;
import br.com.senac.feira.repository.EmpresaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	EmpresaRepository repository;

	public Empresa search(Integer id) throws ObjectNotFoundException {
		Optional<Empresa> empresa = repository.findById(id);

		return empresa.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Empresa.class.getName()));
	}

	public List<Empresa> searchAll() {
		return repository.findAll();
	}

	public Empresa save(Empresa empresa) {
		return repository.save(empresa);
	}

	public Empresa edit(Empresa empresa) throws ObjectNotFoundException {
		Empresa empresaAntiga = search(empresa.getEmpresa_id());
		empresaAntiga.setEmpresa_nome(empresa.getEmpresa_nome());
		empresaAntiga.setEmpresa_cnpj(empresa.getEmpresa_cnpj());
		empresaAntiga.setEmpresa_descricao(empresa.getEmpresa_descricao());
		empresaAntiga.setResponsaveis(empresa.getResponsaveis());
		empresaAntiga.setVagas(empresa.getVagas());
		return save(empresaAntiga);
	}
}