package br.com.senac.feira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.feira.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

}