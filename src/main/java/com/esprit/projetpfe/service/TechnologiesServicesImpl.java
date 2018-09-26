package com.esprit.projetpfe.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esprit.projetpfe.entities.Technologies;
import com.esprit.projetpfe.repository.TechnologiesRepository;


@Component
public class TechnologiesServicesImpl implements ITechnologiesServices {

	@Autowired
	private TechnologiesRepository technologierepository;

	@Override
	public List<Technologies> getAllTechnologies() {
		return (List<Technologies>) technologierepository.findAll();
	}

	@Override
	public void addTechnologie(Technologies technologie) {

		technologierepository.save(technologie);
	}

	@Override
	public String getbyNom(String nom) {
		return technologierepository.findbyNom(nom);
	}
	
	


	
}
