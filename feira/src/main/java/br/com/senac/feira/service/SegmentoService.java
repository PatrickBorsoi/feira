package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.Segmento;
import javassist.tools.rmi.ObjectNotFoundException;

public interface SegmentoService {

	Segmento search(Integer id) throws ObjectNotFoundException;

	List<Segmento> searchAll();

	Segmento save(Segmento segmento);

	Segmento edit(Segmento segmento) throws ObjectNotFoundException;
}