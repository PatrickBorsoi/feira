package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.AreaAtuacao;
import javassist.tools.rmi.ObjectNotFoundException;

public interface AreaAtuacaoService {

	AreaAtuacao search(Integer id) throws ObjectNotFoundException;

	List<AreaAtuacao> searchAll();

	AreaAtuacao save(AreaAtuacao area_atuacao);

	AreaAtuacao edit(AreaAtuacao area_atuacao) throws ObjectNotFoundException;
}