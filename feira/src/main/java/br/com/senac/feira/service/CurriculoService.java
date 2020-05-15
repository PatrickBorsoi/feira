package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.Curriculo;
import javassist.tools.rmi.ObjectNotFoundException;

public interface CurriculoService {

	Curriculo search(Integer id) throws ObjectNotFoundException;

	List<Curriculo> searchAll();

	Curriculo save(Curriculo curriculo);

	Curriculo edit(Curriculo curriculo) throws ObjectNotFoundException;
}