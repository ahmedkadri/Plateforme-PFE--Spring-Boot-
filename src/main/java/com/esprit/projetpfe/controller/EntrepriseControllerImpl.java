package com.esprit.projetpfe.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.projetpfe.entities.Entreprise;
import com.esprit.projetpfe.service.IEntrepriseServices;




@RestController
@RequestMapping(path="/entreprise")
public class EntrepriseControllerImpl{

	@Autowired
	public IEntrepriseServices entrepriseservice ;
	
	
	
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> ajoutEntreprise(@RequestBody Entreprise entreprise)
	{
		
		entrepriseservice.addEntreprise(entreprise);
		
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}

	
	@RequestMapping(value = "/allentreprises",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Entreprise>> getAllEntreprises() {
		
		
		List<Entreprise> listeEntreprises = entrepriseservice.getAllEntreprises();
		
		if(listeEntreprises == null) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity<>(listeEntreprises,HttpStatus.OK);
	}
	
	
	
	   @RequestMapping(value = "/find/{nom}", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	    public ResponseEntity<?> gettech(@PathVariable("nom") String nom) {
	    	String entreprise = entrepriseservice.getNameEntrprise(nom);
	        if (entreprise == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(entreprise, HttpStatus.OK);
	    }


	
	
	
	
	
	
	

}
