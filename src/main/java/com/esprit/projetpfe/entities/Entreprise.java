package com.esprit.projetpfe.entities;

import javax.persistence.*;

@Entity
public class Entreprise {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nom;
	private String address;
	private String pays;
	private String email;
	private int telephone;
	private String representant;
	

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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getRepresentant() {
		return representant;
	}
	public void setRepresentant(String representant) {
		this.representant = representant;
	}
	
	
	public Entreprise() {
		super();
	}
	
}
