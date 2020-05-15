package br.com.senac.feira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.feira.model.EventoTipo;

@Repository
public interface EventoTipoRepository extends JpaRepository<EventoTipo, Integer> {

}