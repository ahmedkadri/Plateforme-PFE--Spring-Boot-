package com.esprit.projetpfe.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.projetpfe.entities.Entreprise;

@Repository
public interface EntrepriseRepository extends CrudRepository<Entreprise, Long> {



	@Query("select e.nom from Entreprise e where e.nom like ?1")
	String getNameEntrprise(String nom);





}

