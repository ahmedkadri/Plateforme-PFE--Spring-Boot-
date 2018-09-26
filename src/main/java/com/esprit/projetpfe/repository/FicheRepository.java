package com.esprit.projetpfe.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.esprit.projetpfe.entities.Fiche;



@Repository
public interface FicheRepository extends CrudRepository<Fiche, Integer> {

	

	@Query("select f from Fiche f where f.etudiant.firstname = ?1 ")
	Fiche getFicheByEtudiantName(String nom);
	
	
	 	@Transactional
	    @Modifying
		@Query("update Fiche f set f.title = ?1, f.description = ?2,"
	+" f.problematique = ?3, f.fonctionnalites = ?4, f.fonctdesc= ?5, "
	+ "f.nomencad = ?6, f.prenomencad = ?7, f.mailencad = ?8, f.numtelencad = ?9 where f.id = ?10")
	    void updatefiche(String title,String description,String problematique,String fonctionnalites, String fonctdesc, String nomencad, String prenomencad, String mailencad,String numencad,int id);






	
}
