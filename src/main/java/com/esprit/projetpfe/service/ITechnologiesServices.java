package com.esprit.projetpfe.service;

import java.util.List;

import com.esprit.projetpfe.entities.Technologies;

public interface ITechnologiesServices {

	
	public List<Technologies> getAllTechnologies();
	
	public void addTechnologie(Technologies technologie);
	
	public String getbyNom(String nom);
	
	
}
