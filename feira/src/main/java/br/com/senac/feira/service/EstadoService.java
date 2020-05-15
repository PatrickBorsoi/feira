package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.Estado;
import javassist.tools.rmi.ObjectNotFoundException;

public interface EstadoService {

	Estado search(Integer id) throws ObjectNotFoundException;

	List<Estado> searchAll();

	Estado save(Estado estado);
	
	Estado edit(Estado estado) throws ObjectNotFoundException;
}