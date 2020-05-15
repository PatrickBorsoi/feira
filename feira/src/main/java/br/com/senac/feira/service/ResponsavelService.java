package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.Responsavel;
import javassist.tools.rmi.ObjectNotFoundException;

public interface ResponsavelService {

	Responsavel search(Integer id) throws ObjectNotFoundException;

	List<Responsavel> searchAll();

	Responsavel save(Responsavel responsavel);

	Responsavel edit(Responsavel responsavel) throws ObjectNotFoundException;
}