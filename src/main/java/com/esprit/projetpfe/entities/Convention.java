package com.esprit.projetpfe.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Convention {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idconvention;
	
	private Date datedebut;
	private Date datefin;
	@OneToOne
	private User etudiant;
	

	
	
	@ManyToOne
	private Entreprise entreprise;

	
	
	public int getIdconvention() {
		return idconvention;
	}

	public void setIdconvention(int idconvention) {
		this.idconvention = idconvention;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	
	
	public User getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(User etudiant) {
		this.etudiant = etudiant;
	}

	
	
	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	
	public Convention() {
		super();
	}
	
}
