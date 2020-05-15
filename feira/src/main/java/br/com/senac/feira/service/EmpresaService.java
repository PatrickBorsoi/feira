package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.Empresa;
import javassist.tools.rmi.ObjectNotFoundException;

public interface EmpresaService {

	Empresa search(Integer id) throws ObjectNotFoundException;

	List<Empresa> searchAll();

	Empresa save(Empresa empresa);

	Empresa edit(Empresa empresa) throws ObjectNotFoundException;
}