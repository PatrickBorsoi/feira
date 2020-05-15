package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.VagaTipo;
import javassist.tools.rmi.ObjectNotFoundException;

public interface VagaTipoService {

	VagaTipo search(Integer id) throws ObjectNotFoundException;

	List<VagaTipo> searchAll();

	VagaTipo save(VagaTipo vaga_tipo);

	VagaTipo edit(VagaTipo vaga_tipo) throws ObjectNotFoundException;
}