package br.com.senac.feira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.feira.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}