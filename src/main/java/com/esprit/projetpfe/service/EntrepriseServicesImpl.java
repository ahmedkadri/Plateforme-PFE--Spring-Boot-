package com.esprit.projetpfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esprit.projetpfe.entities.Entreprise;
import com.esprit.projetpfe.repository.EntrepriseRepository;

@Component
public class EntrepriseServicesImpl implements IEntrepriseServices {

	@Autowired
	private EntrepriseRepository entrepriserepository;

	@Override
	public List<Entreprise> getAllEntreprises() {
		return (List<Entreprise>) entrepriserepository.findAll();
	}

	@Override
	public void addEntreprise(Entreprise entreprise) {
		entrepriserepository.save(entreprise);
		
	}

	@Override
	public String getNameEntrprise(String nom) {
		return entrepriserepository.getNameEntrprise(nom);
	}
}
