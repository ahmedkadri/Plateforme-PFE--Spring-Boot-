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

import com.esprit.projetpfe.entities.Technologies;
import com.esprit.projetpfe.service.ITechnologiesServices;



@RestController
@RequestMapping(path="/technologie")
public class TechnologieControllerImpl {

	
	@Autowired
	public ITechnologiesServices technologieservice;

	@RequestMapping(value="/add",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> ajoutTechnologie(@RequestBody Technologies tech)
	{
		
		technologieservice.addTechnologie(tech);
		
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}



	@RequestMapping(value = "/alltech",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Technologies>> getAlltechnologies() {
		
		
		List<Technologies> listtechnologies = technologieservice.getAllTechnologies();
		
		if(listtechnologies == null) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity<>(listtechnologies,HttpStatus.OK);
	}
	


	
 

    @RequestMapping(value = "/find/{nom}", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
    public ResponseEntity<?> gettech(@PathVariable("nom") String nom) {
    	String technologie = technologieservice.getbyNom(nom);
        if (technologie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(technologie, HttpStatus.OK);
    }









}
