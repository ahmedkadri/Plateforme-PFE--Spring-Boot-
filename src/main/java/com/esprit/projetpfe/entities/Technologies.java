package com.esprit.projetpfe.entities;

import javax.persistence.*;

@Entity
public class Technologies {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nom;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public Technologies() {
		super();
	}
	
	
}
