package br.com.senac.feira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.feira.model.Candidatura;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Integer> {

}