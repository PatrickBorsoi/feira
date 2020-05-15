package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.Stand;
import javassist.tools.rmi.ObjectNotFoundException;

public interface StandService {

	Stand search(Integer id) throws ObjectNotFoundException;

	List<Stand> searchAll();

	Stand save(Stand stand);

	Stand edit(Stand stand) throws ObjectNotFoundException;
}