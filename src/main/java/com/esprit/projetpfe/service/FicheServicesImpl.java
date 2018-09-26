package com.esprit.projetpfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.esprit.projetpfe.entities.Fiche;
import com.esprit.projetpfe.repository.FicheRepository;

@Component
public class FicheServicesImpl implements IFicheServices {

	@Autowired
	private FicheRepository ficherepository;

	@Override
	public List<Fiche> getAllFiches() {

		
		return (List<Fiche>) ficherepository.findAll();
	}



	@Override
	public void addFiche(Fiche fiche) {
		
		ficherepository.save(fiche);
	}

	@Override
	public void deleteFiche(Fiche fiche) {
		ficherepository.delete(fiche);
	}

	@Override
	public void updateFiche(Fiche fiche, int id) {
		
		
		ficherepository.updatefiche(fiche.getTitle(), fiche.getDescription(), fiche.getProblematique(), fiche.getFonctionnalites(), fiche.getFonctdesc(), fiche.getNomencad(), fiche.getPrenomencad(), fiche.getMailencad(), fiche.getNumtelencad(), id);
	}



	@Override
	public Fiche getfichebyetudiant(String nom) {
		// TODO Auto-generated method stub
		return ficherepository.getFicheByEtudiantName(nom);
	}



	






	
}
