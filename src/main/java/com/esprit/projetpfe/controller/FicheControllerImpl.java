package com.esprit.projetpfe.controller;




import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.projetpfe.entities.Fiche;

import com.esprit.projetpfe.service.IFicheServices;




@RestController
@RequestMapping(path="/fiche")
public class FicheControllerImpl{

	@Autowired
	public IFicheServices ficheservice ;
	
	
	
	@RequestMapping(value="/ficheadd",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> ajoutFiche(@RequestBody Fiche fiche)
	{
		
		ficheservice.addFiche(fiche);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	
	
	@RequestMapping(value = "/allfiches",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Fiche>> getfiches() {
		
		
		List<Fiche> listfiches = ficheservice.getAllFiches();
		
		if(listfiches == null) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity<>(listfiches,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int ficheid)
	{
	
		ficheservice.deleteFiche(new Fiche(ficheid));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	    
	@RequestMapping(value = "/find/{nom}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fiche> getFiche(@PathVariable("nom") String nom) {
	    	
	    	
	    	Fiche fiche = ficheservice.getfichebyetudiant(nom);
	    	
	    	if(fiche == null){
	    	
	    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	}
	        return new ResponseEntity<>(fiche, HttpStatus.CREATED);
	    }
	
	
	@RequestMapping(value = "/fiche/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateFiche(@RequestBody Fiche fiche, 
    											@PathVariable("id") int id){

		try{
    		ficheservice.updateFiche(fiche, id);
    	}catch (NoResultException e) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	return new ResponseEntity<>(HttpStatus.OK);
    }


	
}
