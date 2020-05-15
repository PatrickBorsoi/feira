package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.Candidatura;
import javassist.tools.rmi.ObjectNotFoundException;

public interface CandidaturaService {

	Candidatura search(Integer id) throws ObjectNotFoundException;

	List<Candidatura> searchAll();

	Candidatura save(Candidatura candidatura);

	Candidatura edit(Candidatura candidatura) throws ObjectNotFoundException;
}