package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.Cidade;
import javassist.tools.rmi.ObjectNotFoundException;

public interface CidadeService {

	Cidade search(Integer id) throws ObjectNotFoundException;

	List<Cidade> searchAll();

	Cidade save(Cidade cidade);

	Cidade edit(Cidade cidade) throws ObjectNotFoundException;
}