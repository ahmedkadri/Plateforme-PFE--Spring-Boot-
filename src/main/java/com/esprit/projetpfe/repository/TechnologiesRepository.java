package com.esprit.projetpfe.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.projetpfe.entities.Technologies;

@Repository
public interface TechnologiesRepository extends CrudRepository<Technologies, Long> {

	
	
	@Query("select t.nom from Technologies t where t.nom like %?1")
	String findbyNom(String nom);
}
