package com.esprit.projetpfe.service;



import java.util.List;

import com.esprit.projetpfe.entities.Fiche;


public interface IFicheServices {

	
	public List<Fiche> getAllFiches();
	

	
	public void addFiche(Fiche fiche);
	
	public void deleteFiche(Fiche fiche);
	
	public void updateFiche(Fiche fiche, int id);
	
	
	public Fiche getfichebyetudiant(String nom);
	
}
