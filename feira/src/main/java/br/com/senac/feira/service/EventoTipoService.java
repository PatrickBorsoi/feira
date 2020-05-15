package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.EventoTipo;
import javassist.tools.rmi.ObjectNotFoundException;

public interface EventoTipoService {

	EventoTipo search(Integer id) throws ObjectNotFoundException;

	List<EventoTipo> searchAll();

	EventoTipo save(EventoTipo eventoTipo);

	EventoTipo edit(EventoTipo eventoTipo) throws ObjectNotFoundException;
}