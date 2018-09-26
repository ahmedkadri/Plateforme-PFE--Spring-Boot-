package com.esprit.projetpfe.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
@JsonIgnoreProperties(
		value = {"listefiches","ficheEtudiant"}
		)
public class User  {

	@Id
	private String userid;
	
	@NotBlank
    @Size(max = 40)
	private String firstname;
	
	@NotBlank
    @Size(max = 15)
	private String lastname;
	
	@NaturalId
	@NotBlank
	private String usermail;
	
	@NotBlank
    @Size(max = 100)
	private String password;
	


	

	
	@OneToMany
	private List<Fiche> listefiches;
	
	@OneToOne(targetEntity=Fiche.class, mappedBy="etudiant")
	private Fiche ficheEtudiant;


	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getUsermail() {
		return usermail;
	}



	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public List<Fiche> getListefiches() {
		return listefiches;
	}



	public void setListefiches(List<Fiche> listefiches) {
		this.listefiches = listefiches;
	}



	public Fiche getFicheEtudiant() {
		return ficheEtudiant;
	}



	public void setFicheEtudiant(Fiche ficheEtudiant) {
		this.ficheEtudiant = ficheEtudiant;
	}



	public Set<Role> getRoles() {
		return roles;
	}



	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}



	public User(String userid, String firstname, String lastname, String usermail, String password,
			List<Fiche> listefiches, Fiche ficheEtudiant, Set<Role> roles) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.usermail = usermail;
		this.password = password;
		this.listefiches = listefiches;
		this.ficheEtudiant = ficheEtudiant;
		this.roles = roles;
	}



	public User() {
		super();
	}



	public User(String userid) {
		super();
		this.userid = userid;
	}



	public User(String userid, String firstname, String lastname, String usermail, String password
			) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.usermail = usermail;
		this.password = password;
	
	}
	
	

	


}

