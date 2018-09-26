package com.esprit.projetpfe.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity
public class Fiche {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String title;
	private String description;
	private String problematique;
	private String fonctionnalites;
	private String fonctdesc;
	private String nomencad;
	private String prenomencad;
	private String mailencad;
	private String numtelencad;
	@Enumerated(EnumType.STRING)
	private Etat etatfiche;
	

	@OneToOne
	private User etudiant;
	
	@ManyToOne
	private Entreprise entreprise;
	
	@ManyToMany
	private List<Technologies> technologies;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProblematique() {
		return problematique;
	}
	public void setProblematique(String problematique) {
		this.problematique = problematique;
	}
	public String getFonctionnalites() {
		return fonctionnalites;
	}
	public void setFonctionnalites(String fonctionnalites) {
		this.fonctionnalites = fonctionnalites;
	}
	public String getFonctdesc() {
		return fonctdesc;
	}
	public void setFonctdesc(String fonctdesc) {
		this.fonctdesc = fonctdesc;
	}
	public String getNomencad() {
		return nomencad;
	}
	public void setNomencad(String nomencad) {
		this.nomencad = nomencad;
	}
	public String getPrenomencad() {
		return prenomencad;
	}
	public void setPrenomencad(String prenomencad) {
		this.prenomencad = prenomencad;
	}
	public String getMailencad() {
		return mailencad;
	}
	public void setMailencad(String mailencad) {
		this.mailencad = mailencad;
	}
	public String getNumtelencad() {
		return numtelencad;
	}
	public void setNumtelencad(String numtelencad) {
		this.numtelencad = numtelencad;
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
	
	
	
	public List<Technologies> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<Technologies> technologies) {
		this.technologies = technologies;
	}
	public Etat getEtatfiche() {
		return etatfiche;
	}
	public void setEtatfiche(Etat etatfiche) {
		this.etatfiche = etatfiche;
	}
	public Fiche(int id, String title, String description, String problematique, String fonctionnalites,
			String fonctdesc, String nomencad, String prenomencad, String mailencad, String numtelencad, Etat etatfiche,
			User etudiant, Entreprise entreprise, List<Technologies> technologies) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.problematique = problematique;
		this.fonctionnalites = fonctionnalites;
		this.fonctdesc = fonctdesc;
		this.nomencad = nomencad;
		this.prenomencad = prenomencad;
		this.mailencad = mailencad;
		this.numtelencad = numtelencad;
		this.etatfiche = etatfiche;
		this.etudiant = etudiant;
		this.entreprise = entreprise;
		this.technologies = technologies;
	}
	public Fiche() {
		super();
	}
	public Fiche(int id) {
		super();
		this.id = id;
	}
	 

	
	
	
}
