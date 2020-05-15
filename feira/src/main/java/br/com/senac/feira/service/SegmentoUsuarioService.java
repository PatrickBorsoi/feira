package br.com.senac.feira.service;

import java.util.List;

import br.com.senac.feira.model.SegmentoUsuario;
import javassist.tools.rmi.ObjectNotFoundException;

public interface SegmentoUsuarioService {

	SegmentoUsuario search(Integer id) throws ObjectNotFoundException;

	List<SegmentoUsuario> searchAll();

	SegmentoUsuario save(SegmentoUsuario segmentoUsuario);

	SegmentoUsuario edit(SegmentoUsuario segmentoUsuario) throws ObjectNotFoundException;
}