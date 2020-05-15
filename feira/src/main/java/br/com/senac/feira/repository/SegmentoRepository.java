package br.com.senac.feira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.feira.model.Segmento;

@Repository
public interface SegmentoRepository extends JpaRepository<Segmento, Integer> {

}