package com.esprit.projetpfe.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.projetpfe.repository.ConventionRepository;

public class ConventionServicesImpl implements IConventionServices {

	@Autowired
	private ConventionRepository conventionrepository;
}
