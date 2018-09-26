package com.esprit.projetpfe.service;

import java.util.List;

import com.esprit.projetpfe.entities.Entreprise;

public interface IEntrepriseServices {

	
	
	
	
	public List<Entreprise> getAllEntreprises();
	

	
	public void addEntreprise(Entreprise entreprise);
	
	
	public String getNameEntrprise(String nom);
	
	
	
	
	
}
