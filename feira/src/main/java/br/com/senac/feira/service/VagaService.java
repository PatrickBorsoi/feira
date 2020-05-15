package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.Vaga;
import javassist.tools.rmi.ObjectNotFoundException;

public interface VagaService {

	Vaga search(Integer id) throws ObjectNotFoundException;

	List<Vaga> searchAll();

	Vaga save(Vaga vaga);

	Vaga edit(Vaga vaga) throws ObjectNotFoundException;
}