package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.Bairro;
import javassist.tools.rmi.ObjectNotFoundException;

public interface BairroService {

	Bairro search(Integer id) throws ObjectNotFoundException;

	List<Bairro> searchAll();

	Bairro save(Bairro bairro);

	Bairro edit(Bairro bairro) throws ObjectNotFoundException;
}