package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.Evento;
import javassist.tools.rmi.ObjectNotFoundException;

public interface EventoService {

	Evento search(Integer id) throws ObjectNotFoundException;

	List<Evento> searchAll();

	Evento save(Evento evento);

	Evento edit(Evento evento) throws ObjectNotFoundException;
}