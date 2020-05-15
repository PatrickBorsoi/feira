package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.EtapaProcesso;
import javassist.tools.rmi.ObjectNotFoundException;

public interface EtapaProcessoService {

	EtapaProcesso search(Integer id) throws ObjectNotFoundException;

	List<EtapaProcesso> searchAll();

	EtapaProcesso save(EtapaProcesso etapaProcesso);

	EtapaProcesso edit(EtapaProcesso etapaProcesso) throws ObjectNotFoundException;
}